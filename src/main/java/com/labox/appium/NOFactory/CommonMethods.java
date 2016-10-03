package com.labox.appium.NOFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public AppiumDriver driver;
    public Manager manager;

    public CommonMethods(Manager manager) {
        this.manager = manager;

        this.driver = manager.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);

    }
}
