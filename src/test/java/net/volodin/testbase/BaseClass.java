package net.volodin.testbase;

import net.volodin.utils.ConfigsReader;
import net.volodin.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static WebDriver driver;

    /**
     * Method creates, configures and returns it
     *
     * @return Return basically setup instance of Web-driver
     */
    public static WebDriver setUp() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported!");
        }

        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigsReader.getProperty("url"));

        // we initialize all the page elements of the classes in package com.neotech.pages
        PageInitializer.initialize();

        return driver;
    }

    /**
     * Method  quits the browser
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}