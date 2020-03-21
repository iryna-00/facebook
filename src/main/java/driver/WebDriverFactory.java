package driver;

import consts.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static consts.Constants.Configuration.FIREFOX_NAME;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    private static WebDriver webDriver;

    public static void initDriver(final String browserName) {
        if (Constants.Configuration.CHROME_NAME.equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);
        } else if (FIREFOX_NAME.equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        if (!(webDriver instanceof ChromeDriver)) {
            webDriver.manage().window().maximize();
        }
        threadLocalWebDriver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    public static void quitDriver() {
        if (webDriver != null) {
            threadLocalWebDriver.get().quit();
            threadLocalWebDriver.remove();
        }
    }

}
