package com.labox.appium.pages;

import com.labox.appium.config.ApplicationManager;
import com.labox.appium.config.HelperBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends HelperBase {
    public LoginPage(ApplicationManager manager) {
        super(manager);

    }

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/userId_text")
    public MobileElement username;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/password_text")
    public MobileElement password;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/password_text")
    public MobileElement btnSignIn;

    public  void login(String user, String passw){
        username.click();
        username.clear();
        username.sendKeys(user);
        password.click();
        password.sendKeys(passw);
        btnSignIn.click();
    }







}
