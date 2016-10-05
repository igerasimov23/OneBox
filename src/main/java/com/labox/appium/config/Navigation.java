package com.labox.appium.config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.Dimension;

/**
 * Created by ilyagerasimov on 10/5/16.
 */
public class Navigation extends HelperBase {
    public Navigation(ApplicationManager manager) {
        super(manager);
    }

    /*
    *Till text exist need to be tested
    *
    */
    public void swipeRightUntilTextExists(String expected) {
        do {
            swipeRight();
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        driver.swipe(startx, starty, endx, starty, 1000);
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        driver.swipe(startx, starty, endx, starty, 1000);
    }

    public void swipeDown() throws InterruptedException {

        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.5);
        int endx = (int) (size.width * 0.5);
        int starty = (int) (size.height * 0.75);
        int endy = (int) (size.height * 0.1);
        driver.swipe(startx, starty, endx, endy, 0);
//        Thread.sleep(1000);
    }

    public void tapBackButtonOnDevice(){
        driver.navigate().back();
    }

    public void scrollDirection(MobileElement Id, SwipeElementDirection arg) {
        MobileElement e = Id;
        e.swipe(arg, 1000);
    }




}
