package com.labox.appium.config;

import com.labox.appium.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;
    private HelperBase helperBase;
    private Navigation navigation;
    private String device;
    private String platform_name;
    private String platform_version;

    private   DesiredCapabilities capIos;
    private   DesiredCapabilities capAndr;




     protected ApplicationManager(String port, String device,
                              String platform_name, String platform_version) throws MalformedURLException {

        this.device = device;
        this.platform_name = platform_name;
        this.platform_version = platform_version;


        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String fileLocationAndr = properties.getProperty("fileAndroid");
        String fileLocationIos = properties.getProperty("fileIOS");

        File andrPath = new File(fileLocationAndr);
        File iosPath = new File(fileLocationIos);

        if(platform_name.equalsIgnoreCase("iOS")){
            capIos = new DesiredCapabilities();
            System.out.println("ios: " + platform_name + " " + device + " " + platform_version);
            capIos.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
            capIos.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
            capIos.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capIos.setCapability(MobileCapabilityType.APP, iosPath.getAbsolutePath());
            System.out.println(iosPath.getAbsolutePath());
            driver = new IOSDriver<>(new URL("http://localhost:" + port+ "/wd/hub"), capIos);

        }
        else if (platform_name.equalsIgnoreCase("android")){
            capAndr = new DesiredCapabilities();
            System.out.println("android: " + platform_name + " " + device + " " + platform_version);
            capAndr.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
            capAndr.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
            capAndr.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capAndr.setCapability(MobileCapabilityType.APP, andrPath.getAbsolutePath());
        capAndr.setCapability("appPackage", "com.altice.labox");
//        //Activity to open Log In screen for Android
        capAndr.setCapability("appActivity", "com.altice.labox.splashscreen.presentation.SplashActivity");

            driver = new AndroidDriver<>(new URL("http://localhost:" + port + "/wd/hub"), capAndr);

        }
//


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        /*String fileLocation = "C:/cablevision/optimum4.6.0.1_arm_stg2.apk";
        DesiredCapabilities capIos = new DesiredCapabilities();
        capIos.setCapability("deviceName", "phone");
        capIos.setCapability("app", fileLocation);
        capIos.setCapability("appPackage", "com.optimum.rdvr.mobile");
        //Activity to open Log In screen for Android
        capIos.setCapability("appActivity", "com.cablevision.optimum2.utility.SplashScreen");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capIos);*/


//        page init


//        loginPage = new LoginPage(this);
//        helperBase = new HelperBase(this);

    }

    public LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(this);
        return loginPage;
    }

    public HelperBase getHelperBase(){
        if (helperBase == null)
            helperBase = new HelperBase(this);
        return helperBase;
    }

    public Navigation getNavigation(){
        if(navigation == null)
            navigation = new Navigation(this);
        return navigation;
    }
    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public void exit(){
        driver.quit();
    }


}
