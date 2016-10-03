package com.labox.appium.NOFactory;

import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test
    public void loginTest(){

//    LoginPage_works loginPage = new LoginPage_works(driver);
        manager.loginPage.login("user", "00000000");

//    loginPage.login("user", "0000");



}


}
