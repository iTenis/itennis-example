package com.itennishy.test.controller;

import com.itennishy.test.domain.ConnectionInfo;
import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/sshd")
public class SSHController {

    Map<String, PipedOutputStream> inputMap = new HashMap<String, PipedOutputStream>();

    Map<String, ByteArrayOutputStream> outputMap = new HashMap<String, ByteArrayOutputStream>();

    /**
     * 启动客户端
     * @param connectionInfo
     */
    @PostMapping(value = "/startClient")
    public void startClient(@RequestBody ConnectionInfo connectionInfo){
        String host = connectionInfo.getHost();
        int port = connectionInfo.getPost();
        String username = connectionInfo.getUsername();
        String password = connectionInfo.getPassword();
        String token = connectionInfo.getToken();

        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        try {
            ClientSession session = client.connect(host, port).await().getSession();
            if(session.authPassword(username, password).await().isSuccess()){
                ClientChannel channel = session.createShellChannel();
                PipedOutputStream pipedIn = new PipedOutputStream();
                channel.setIn(new PipedInputStream(pipedIn));
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                channel.setOut(out);
                ByteArrayOutputStream err = new ByteArrayOutputStream();
                channel.setErr(err);
                channel.open();
                inputMap.put(token, pipedIn);
                outputMap.put(token, out);
                channel.waitFor(ClientChannel.CLOSED, 0);
                inputMap.remove(token);
                outputMap.remove(token);
                channel.close(false);
                session.close(false);
                client.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 找到对应客户端并下发命令
     * @param connectionInfo
     */
    @PostMapping(value = "/sendCommand")
    public String sendCommand(@RequestBody ConnectionInfo connectionInfo)  {
        String command = connectionInfo.getCommand();
        String token = connectionInfo.getToken();
        PipedOutputStream pipedIn = inputMap.get(token);
        ByteArrayOutputStream out = outputMap.get(token);

        if(pipedIn != null && out != null){
            try {
                if(command != null){
                    pipedIn.write(command.getBytes());
                    pipedIn.flush();
                }
                while (true){
                    byte[] a = out.toByteArray();
                    Thread.sleep(500);
                    byte[] b = out.toByteArray();
                    if(b.length == a.length){
                        out.reset();
                        return new String(b, "GBK");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "";
    }
}