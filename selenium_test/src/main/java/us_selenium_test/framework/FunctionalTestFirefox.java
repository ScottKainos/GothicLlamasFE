package us_selenium_test.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTestFirefox {

    protected static WebDriver firefoxDriver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeTest
    public void launchBrowser() {
        WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firefoxDriver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        firefoxDriver.quit();
    }


}
