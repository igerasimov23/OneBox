package com.labox.appium.config;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;

public abstract class BaseTest {

    protected ApplicationManager app;


    public static void startServer(){

        try {
            String[] command = {"cmd.exe", "/C", "Start", "Devices/server-run1.bat"};
            Process p =  Runtime.getRuntime().exec(command);
            Thread.sleep(5000);
        } catch (IOException ex) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        CommandLine command = new CommandLine("cmd");
//        command.addArgument("/c");
//        command.addArgument("cd");
//        command.addArgument("c:\\IdeaProjects\\OneBoxAppium\\");
//        command.addArgument("java");
//        command.addArgument("-jar");
//        command.addArgument("selenium-server-standalone-2.53.0.jar");
//        command.addArgument("-port");
//        command.addArgument("4444");
//        command.addArgument("-role");
//        command.addArgument("hub");
//
//        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//        DefaultExecutor executor = new DefaultExecutor();
//        executor.setExitValue(1);
//
//        try {
//            executor.execute(command, resultHandler);
//            Thread.sleep(10000);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void startMotog() {
//       CreateNode createNode = new CreateNode();
//       createNode.runScript("sh Devices/motog.sh");
        CommandLine oCmdLine = CommandLine.parse("sh Devices/motog.sh");
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


//        try {
//            String[] command = {"cmd.exe", "/C", "Start", "c:\\IdeaProjects\\OneBoxAppium\\server-run1.bat"};
//            Process p =  Runtime.getRuntime().exec(command);
//            Thread.sleep(4000);
//        } catch (IOException ex) {
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//      CommandLine command = new CommandLine("cmd");
//        command.addArgument("/c");
//        command.addArgument("appium");
//
//        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//        DefaultExecutor executor = new DefaultExecutor();
//        executor.setExitValue(1);
//
//        try {
//            executor.execute(command, resultHandler);
//            Thread.sleep(10000);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
       /* ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--address", "127.0.0.1");
        serverArguments.setArgument("--no-reset", true);
        serverArguments.setArgument("--local-timezone", true);
        AppiumServer _appiumServer = new AppiumServer(serverArguments);*/
//        AppiumServer _appiumServer = new AppiumServer(new File("C:/Users/Dell/appdata/Roaming/npm/node_modules/appium/build/lib/main.js"), serverArguments);
//        _appiumServer.startMotog();
//        _appiumServer.isServerRunning()
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void startIphone6() {
//        CreateNode createNode = new CreateNode();
//        createNode.runScript("sh Devices/iphone6.sh");
//        CommandLine oCmdLine = CommandLine.parse("sh Devices/iphone6.sh");
//        DefaultExecutor oDefaultExecutor = new DefaultExecutor();
//        oDefaultExecutor.setExitValue(1);
//        try {
//            oDefaultExecutor.execute(oCmdLine);
//        } catch (ExecuteException e) {
//            System.err.println("Execution failed.");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("permission denied.");
//            e.printStackTrace();
//        }


//        CommandLine command = new CommandLine("cmd");
//        command.addArgument("/c");
//        command.addArgument("appium");
//        command.addArgument("--nodeconfig");
//        command.addArgument("Devices/galaxys7.json");
//        command.addArgument("-p");
//        command.addArgument("4725");
//        command.addArgument("-U");
//        command.addArgument("e552347a");
//        command.addArgument("--log");
//        command.addArgument("Devices/galaxys7.txt");
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
    }

    public static void stopNode() throws IOException {
        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c");
        command.addArgument("Taskkill /F /IM node.exe");

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        executor.execute(command, resultHandler);



    }


    @BeforeClass(alwaysRun=true)
    @Parameters({"port", "device", "platform_name", "platform_version"})
    public  void beforeTest(String port, String device,
                                  String platform_name, String platform_version) throws MalformedURLException {
//        startServer();
//        startMotog();

        app = new ApplicationManager(port, device,
                platform_name,  platform_version);
    }


    @AfterClass(alwaysRun = true)
    public  void afterClass() throws IOException {
//        app.driver.quit();
//        stopNode();
        app.exit();
    }
}
