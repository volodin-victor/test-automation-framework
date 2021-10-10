package net.volodin.testbase;

import org.openqa.selenium.safari.SafariDriver;

public class SafariInit extends AbstractBrowserInit {

    public static SafariDriver getDriver() {
        SafariDriver driver = new SafariDriver();
        driver.manage().window().setPosition(getPosition());
        driver.manage().window().setSize(getSize());
        return driver;
    }
}
