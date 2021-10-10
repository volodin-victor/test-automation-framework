package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.volodin.utils.ConfigsReader;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxInit extends AbstractBrowserInit {
    public static FirefoxDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Boolean.parseBoolean(ConfigsReader.getProperty("headless"))) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            firefoxOptions.setBinary(firefoxBinary);
        }
        return new FirefoxDriver(firefoxOptions);
    }
}
