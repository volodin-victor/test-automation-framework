package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerInit {
    public static InternetExplorerDriver getDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
