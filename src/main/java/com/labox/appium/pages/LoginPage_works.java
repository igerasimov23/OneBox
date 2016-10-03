package com.labox.appium.pages;

import com.labox.appium.NOFactory.CommonMethods;
import com.labox.appium.NOFactory.Manager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage_works extends CommonMethods {


//    public LoginPage_works(AppiumDriver driver)  {
//        super(driver);
//
////        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
//    }

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/userId_text")
    public MobileElement username;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/password_text")
    public MobileElement password;

    @AndroidFindBy(id = "com.optimum.rdvr.mobile:id/password_text")
    public MobileElement btnSignIn;

    public LoginPage_works(Manager manager) {
        super(manager);
    }

    public  void login(String user, String passw){
        username.click();
        username.clear();
        username.sendKeys(user);
        password.click();
        password.sendKeys(passw);
        driver.navigate().back();
//        btnSignIn.click();
//        driver.quit();
    }

}
