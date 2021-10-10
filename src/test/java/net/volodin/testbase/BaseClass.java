package net.volodin.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.volodin.utils.CommonMethods;
import net.volodin.utils.ConfigsReader;
import net.volodin.utils.Constants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    /**
     * Method creates, configures and returns it
     *
     * @return Return basically setup instance of Web-driver
     */
    public static WebDriver setUp(String testEnv) {
        String browser = ConfigsReader.getProperty("browser").toLowerCase();
        Dimension size = new Dimension(CommonMethods.scrWidth(), CommonMethods.scrHeight());
        Point position = new Point(0, 0);

        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome":
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
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (Boolean.parseBoolean(ConfigsReader.getProperty("headless"))) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().setPosition(position);
                    driver.manage().window().setSize(size);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }


        } else if (testEnv.equals("grid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            try {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(hubUrl, capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Unsupported test environment: " + testEnv);
        }

        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigsReader.getProperty("url"));

        PageInitializer.initialize();

        return driver;
    }

    /**
     * Methods create web-driver object with environment parameter
     *
     * @return Return setup and instantiated Web-driver
     */
    public static WebDriver setUp() {
        return setUp(ConfigsReader.getProperty("environment"));
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