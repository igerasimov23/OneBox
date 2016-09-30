package com.labox.appium.config;

import com.labox.appium.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    public AppiumDriver driver;
    public LoginPage loginPage;
    public HelperBase helperBase;



    public ApplicationManager(String device,
                              String platform_name, String platform_version) throws MalformedURLException {

        String fileLocation = "C:/cablevision/optimum4.6.0.1_arm_stg2.apk";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.APP, fileLocation);
        capabilities.setCapability("appPackage", "com.optimum.rdvr.mobile");
        //Activity to open Log In screen for Android
        capabilities.setCapability("appActivity", "com.cablevision.optimum2.utility.SplashScreen");
        driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        /*String fileLocation = "C:/cablevision/optimum4.6.0.1_arm_stg2.apk";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "phone");
        capabilities.setCapability("app", fileLocation);
        capabilities.setCapability("appPackage", "com.optimum.rdvr.mobile");
        //Activity to open Log In screen for Android
        capabilities.setCapability("appActivity", "com.cablevision.optimum2.utility.SplashScreen");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/


//        page init


        loginPage = new LoginPage(this);
        helperBase = new HelperBase(this);

    }


}
