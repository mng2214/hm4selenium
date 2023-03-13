package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {
    private static WebDriver driver;

    private DriverHelper() {}
    // i make my constructor private because i dont want anyone create an object
    //and manipulate my driver from this class

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            String browser = "chrome";
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    DesiredCapabilities cp = new DesiredCapabilities();
                    cp.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(cp);
                    driver = new ChromeDriver(options);

                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    DesiredCapabilities cp1 = new DesiredCapabilities();
                    cp1.setCapability(ChromeOptions.CAPABILITY, options1);
                    options1.merge(cp1);
                    driver = new ChromeDriver(options1);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
        return driver;
    }
}