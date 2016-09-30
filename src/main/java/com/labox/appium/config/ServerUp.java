package com.labox.appium.config;

import java.io.IOException;

public class ServerUp {

    public static void startServer() throws IOException {
      /*  List cmdAndArgs = Arrays.asList("cmd", "/c", "server-run1.bat");
//        File dir = new File("C:/Program Files/salesforce.com/Data Loader/cliq_process/upsert");

        ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
//        pb.directory(dir);
        Process p = pb.start();
    }*/

        try {
            String[] command = {"cmd.exe", "/C", "Start", "C:\\IdeaProjects\\OneBoxAppium\\server-run1.bat"};
            Process p =  Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) throws IOException {
        startServer();
    }
}
