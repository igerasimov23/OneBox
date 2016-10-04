package com.labox.appium.pages;

import com.labox.appium.config.ApplicationManager;
import com.labox.appium.config.HelperBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends HelperBase {
    public LoginPage(ApplicationManager manager) {
        super(manager);


    }

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/userId_text")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")
    public MobileElement username;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/password_text")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")
    public MobileElement password;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/signin")
    public MobileElement btnSignIn;

    public  void login(String user, String passw){
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
