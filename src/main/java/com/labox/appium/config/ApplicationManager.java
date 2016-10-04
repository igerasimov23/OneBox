package com.labox.appium.config;

import com.labox.appium.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    public AppiumDriver<MobileElement> driver;
    public LoginPage loginPage;
    public HelperBase helperBase;
    public String device;
    public String platform_name;
    public String platform_version;

    public static DesiredCapabilities capabilities;



    public ApplicationManager(String port,String device,
                              String platform_name, String platform_version) throws MalformedURLException {

        this.device = device;
        this.platform_name = platform_name;
        this.platform_version = platform_version;


        String fileLocationAndr = "/Users/ilyagerasimov/Downloads/optimum4.6.0.1_arm_stg2.apk";
        String fileLocationIos = "/Users/ilyagerasimov/Library/Developer/Xcode/DerivedData/UnityApp-delehfqpynmvfzbdnenbcrybjkwy/Build/Products/Debug-iphoneos/CVCrDVR.app";

        File andrPath = new File(fileLocationAndr);
        File iosPath = new File(fileLocationIos);

         capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        if(platform_name.equalsIgnoreCase("ios")){
            System.out.println("ios: " + platform_name + " " + device + " " + platform_version);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability(MobileCapabilityType.APP, iosPath.getAbsolutePath());
            System.out.println(iosPath.getAbsolutePath());
            driver = new IOSDriver<>(new URL("http://localhost:4444/wd/hub"), capabilities);

        }
        else if (platform_name.equalsIgnoreCase("android")){
            System.out.println("android: " + platform_name + " " + device + " " + platform_version);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability(MobileCapabilityType.APP, andrPath.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.optimum.rdvr.mobile");
//        //Activity to open Log In screen for Android
        capabilities.setCapability("appActivity", "com.cablevision.optimum2.utility.SplashScreen");
            driver = new AndroidDriver<>(new URL("http://localhost:4444/wd/hub"), capabilities);

        }
//


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

    public void exit(){
        driver.quit();
    }


}
