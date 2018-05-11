package com.maintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    //driver store vairable
    public static WebDriver browser;
    //this will check if the object is pre created or not
    private volatile static DriverSingleton _instance;

    /**
     * 1st version: creates multiple instance if two thread access
     * this method simultaneously
     */
    public static DriverSingleton getInstance() {
        if (_instance == null) {
            _instance = new DriverSingleton();
        }
        return _instance;
    }

    private DriverSingleton(){
        //logic is here
        this.browser = getBrowser();
    }

    private WebDriver getBrowser() {
        //Default is chrome
        System.setProperty("webdriver.chrome.driver", "E:\\dependencies\\chromedriver.exe");
        return new ChromeDriver();
    }
}
