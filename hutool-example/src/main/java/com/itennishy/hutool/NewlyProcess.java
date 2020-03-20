package com.itennishy.hutool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewlyProcess {
    public static void main(String[] args) throws IOException, InterruptedException {
        createProcess("java", "-version");
        createProcess("git","status");
    }

    private static void createProcess(String... cmd) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        process.waitFor();

        InputStream in = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------\n");
        sb.append("commands:\t")
                .append(Arrays.toString(cmd))
                .append("\n");
        sb.append("RESULT:\t").append("\n");
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        sb.append("---------------------------------\n");

        System.out.println(sb.toString());
    }
}