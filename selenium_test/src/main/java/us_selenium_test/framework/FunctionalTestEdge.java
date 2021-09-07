package us_selenium_test.framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTestEdge {
    protected static WebDriver edgeDriver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);


    @BeforeTest
    public void launchBrowser() {
        WebDriverManager.edgedriver().browserVersion(browserVersion).setup();
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        edgeDriver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        edgeDriver.quit();
    }

}
