package com.labox.appium.config;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;

public abstract class BaseTest {

    public static ApplicationManager app;

    public static void startServer() {
        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c");
        command.addArgument("appium");

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);

        try {
            executor.execute(command, resultHandler);
            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() throws IOException {
        CommandLine command = new CommandLine("cmd");
        command.addArgument("/c");
        command.addArgument("Taskkill /F /IM node.exe");

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        executor.execute(command, resultHandler);

    }


    @BeforeClass
    public static void beforeTest() throws MalformedURLException {
        startServer();
        app = new ApplicationManager();
    }


    @AfterClass
    public  void afterClass() throws IOException {
        app.driver.closeApp();
        stopAppiumServer();
    }
}
