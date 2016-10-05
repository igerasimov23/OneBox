package com.labox.appium.pages;

import com.labox.appium.config.ApplicationManager;
import com.labox.appium.config.HelperBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;

public class LoginPage extends HelperBase {
    public LoginPage(ApplicationManager manager) {
        super(manager);


    }

    @AndroidFindBy(id = "com.altice.labox:id/userId_text")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")
    private MobileElement username;

    @AndroidFindBy(id = "com.altice.labox:id/password_text")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")
    private MobileElement password;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/signin")
    public MobileElement btnSignIn;

    public  void login(String user, String passw){
        System.out.println(driver);
//        AndroidElement element = (AndroidElement) username;
//        element.replaceValue(user);
//        manager.getNavigation().tapBackButtonOnDevice();
//        password.click();

//        AndroidElement element1 = (AndroidElement) password;
//        element1.replaceValue(passw);

        username.click();
        username.clear();
        username.sendKeys(user);
        password.click();
        password.sendKeys(passw);
//        driver.navigate().back();
//        btnSignIn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.quit();
    }







}
