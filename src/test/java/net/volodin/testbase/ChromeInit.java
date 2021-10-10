package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.volodin.utils.ConfigsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeInit extends AbstractBrowserInit {
    public static ChromeDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        Map<String, Object> chromePreferences = new HashMap<>();

        chromePreferences.put("profile.default_content_settings.geolocation", 2);
        chromePreferences.put("download.prompt_for_download", false);
        chromePreferences.put("download.directory_upgrade", true);
        chromePreferences.put("credentials_enable_service", false);
        chromePreferences.put("password_manager_enabled", false);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setExperimentalOption("prefs", chromePreferences);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        if (Boolean.parseBoolean(ConfigsReader.getProperty("headless"))) {
            chromeOptions.setHeadless(true);
            chromeOptions.addArguments("--window-size=" + getSize().getWidth() + "," + getSize().getWidth());
            chromeOptions.addArguments("--disable-gpu");
        }
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
