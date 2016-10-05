package com.labox.appium.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public  class HelperBase  {
    public AppiumDriver driver;
    public ApplicationManager manager;
    private static final int DEFAULT_TIMEOUT = 5;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
    }

    private void changeImplicitWait(int value, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }

    private void restoreDeaultImplicitWait() {
        changeImplicitWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public WebElement forElementClickable(MobileElement element, int time) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element ));
        } catch (WebDriverException e) {
            throw e;
        } finally {
            restoreDeaultImplicitWait();
        }
    }

    public WebElement forElementPresent(MobileElement element, int time) {
        changeImplicitWait(0, TimeUnit.MILLISECONDS);
        try {
            return new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element ));
        } catch (WebDriverException e) {
            throw e;
        } finally {
            restoreDeaultImplicitWait();
        }
    }



}
