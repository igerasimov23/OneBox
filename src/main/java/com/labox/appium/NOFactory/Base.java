package com.labox.appium.NOFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class Base {

//    public AppiumDriver<MobileElement> driver;

      Manager manager;



    @BeforeClass(alwaysRun=true)
    @Parameters({"port", "device", "platform_name", "platform_version"})
    public void testsetup(String port, String device,
                          String platform_name, String platform_version) throws MalformedURLException, InterruptedException{

        manager = new Manager(port, device,
                platform_name,  platform_version);

    }


    @AfterClass
    public void quit(){
        manager.exit();
    }
}
