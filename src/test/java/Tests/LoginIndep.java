package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginIndep {

    public  AndroidDriver<MobileElement> driver;

    public static DesiredCapabilities cap;

    @BeforeTest(alwaysRun=true)
    @Parameters({"port", "device", "platform_name", "platform_version"})
    public void testsetup(String port, String device,
                          String platform_name, String platform_version) throws MalformedURLException, InterruptedException{

        String path = "C:/cablevision/optimum4.6.0.1_arm_stg2.apk";
        File file = new File(path);

        cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);

        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        cap.setCapability(MobileCapabilityType.APP, file);

        driver = new AndroidDriver<>(new URL("http://localhost:"+port+"/wd/hub"), cap);

        System.out.println("session id is---"+driver.getSessionId());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void ValidLoginTest() throws InterruptedException{
        driver.findElement(By.id("com.optimum.rdvr.mobile:id/userId_text")).click();
        driver.findElement(By.id("com.optimum.rdvr.mobile:id/userId_text")).sendKeys("user");

        driver.findElement(By.id("com.optimum.rdvr.mobile:id/password_text")).click();
        driver.findElement(By.id("com.optimum.rdvr.mobile:id/password_text")).sendKeys("0000");


    }



    @AfterTest
    public void quit(){
        driver.quit();
    }


}


