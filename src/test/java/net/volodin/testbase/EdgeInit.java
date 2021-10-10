package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeInit extends AbstractBrowserInit{
    private static EdgeDriver driver;

    public static EdgeDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
