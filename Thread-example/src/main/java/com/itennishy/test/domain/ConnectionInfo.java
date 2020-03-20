package com.itennishy.test.domain;

public class ConnectionInfo {

    // 服务端ip
    private String host;

    // 服务端端口
    private int post;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 下发的命令
    private String command;

    // 每个客户端的唯一标识
    private String token;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}