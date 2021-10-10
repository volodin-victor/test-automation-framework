package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;

public class OperaInit {
    public static OperaDriver getDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
