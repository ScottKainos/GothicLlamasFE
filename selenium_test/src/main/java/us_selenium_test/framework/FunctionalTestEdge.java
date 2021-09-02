package us_selenium_test.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTestEdge {
    protected static WebDriver edgeDriver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeClass
    public static void setUp() {
        WebDriverManager.edgedriver().browserVersion(browserVersion).setup();
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        edgeDriver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        edgeDriver.close();
    }

}
