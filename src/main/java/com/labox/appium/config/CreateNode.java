package com.labox.appium.config;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import java.io.IOException;

/**
 * Created by ilyagerasimov on 10/5/16.
 */
public class CreateNode {

//    public static void main(String[] args) throws IOException, InterruptedException {
//        try {
//            Runtime.getRuntime().exec(new String[] {"open", "-a", "/Applications/Utilities/Terminal.app/"});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        CommandLine command = new CommandLine("open /Applications/Utilities/Terminal.app/");
//
//
//        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//        DefaultExecutor executor = new DefaultExecutor();
//        executor.setExitValue(1);
//
//        try {
//            executor.execute(command, resultHandler);
//            Thread.sleep(15000);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        CommandLine command = new CommandLine("/bin/sh -c");
////        command.addArgument("/c");
//        command.addArgument("appium");
////        command.addArgument("--nodeconfig");
////        command.addArgument("Devices/motog.json");
////        command.addArgument("-p");
////        command.addArgument("4725");
////        command.addArgument("-bootstrap-port");
////        command.addArgument("5055");
////        command.addArgument("-U");
////        command.addArgument("TA9190143I");
////        command.addArgument("--log");
////        command.addArgument("Devices/motog.txt");
//
//        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//        DefaultExecutor executor = new DefaultExecutor();
//        executor.setExitValue(1);
//
//        try {
//            executor.execute(command, resultHandler);
//            Thread.sleep(20000);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        String[] cmd = new String[]{"/bin/sh", "/Users/ilyagerasimov/IdeaProjects/OneBox/Devices/motog.sh"};
//        Process pr = Runtime.getRuntime().exec(cmd);

////        String[] env = {"PATH=/bin:/usr/bin/"};
//        String cmd = "./motog.sh";  //e.g test.sh -dparam1 -oout.txt
//        Process process = Runtime.getRuntime().exec(cmd);

//        ProcessBuilder pb = new ProcessBuilder("sudo", "/Users/ilyagerasimov/IdeaProjects/OneBox/Devices/motog.sh");
//
//        Process p = pb.start();
//        Thread.sleep(100000);
//
//    }



    public void runScript(String command){

        CommandLine oCmdLine = CommandLine.parse(command);
        DefaultExecutor oDefaultExecutor = new DefaultExecutor();
        oDefaultExecutor.setExitValue(1);
        try {
            oDefaultExecutor.execute(oCmdLine);
        } catch (ExecuteException e) {
            System.err.println("Execution failed.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("permission denied.");
            e.printStackTrace();
        }
    }

//    public static void main(String args[]){
//        CreateNode testScript = new CreateNode();
//        testScript.runScript("sh Devices/motog.sh");
//    }

}
