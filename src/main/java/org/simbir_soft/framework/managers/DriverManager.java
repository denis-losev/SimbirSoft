package org.simbir_soft.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.simbir_soft.framework.utils.PropConstants.*;

public class DriverManager {

    private WebDriver driver = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();

    private static DriverManager INSTANCE = null;

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = getWebDriver(testPropManager.getProperty(BROWSER_TYPE));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }

    private WebDriver getWebDriver(String browser) {
        switch (browser){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", testPropManager.getProperty(PATH_CHROME_DRIVER));
                return new ChromeDriver(options);
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", testPropManager.getProperty(PATH_FIREFOX_DRIVER));
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Error: WebDriver not found");
        }
    }
}
