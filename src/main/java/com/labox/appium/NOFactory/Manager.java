package com.labox.appium.NOFactory;

import com.labox.appium.pages.LoginPage_works;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Manager {
    public AppiumDriver<MobileElement> driver;
    LoginPage_works loginPage;
    public static DesiredCapabilities cap;

 public  Manager(String port, String device,
                 String platform_name, String platform_version) throws MalformedURLException {

     String path = "C:/cablevision/optimum4.6.0.1_arm_stg2.apk";
     File file = new File(path);


     cap = new DesiredCapabilities();

     cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);

     cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);

     cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

     cap.setCapability(MobileCapabilityType.APP, file);
     cap.setCapability("appPackage", "com.optimum.rdvr.mobile");
     //Activity to open Log In screen for Android
     cap.setCapability("appActivity", "com.cablevision.optimum2.utility.SplashScreen");

     driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4444/wd/hub"), cap);

     System.out.println("session id is---"+driver.getSessionId());

     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

     loginPage = new LoginPage_works(this);

 }

    public void exit(){
        driver.quit();
    }



}
