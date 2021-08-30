package us001_selenium_test.framework;

import com.testautomationguru.ocular.Ocular;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeSuite
    public static void ocularSetUp (){
        String resultPath = "/Users/sylwia.luczak-jagiela/IdeaProjects/GothicLlamasFE/selenium_test/src/main/java/us001_selenium_test/page_models/ocular_result";
        String snapshotPath = "/Users/sylwia.luczak-jagiela/IdeaProjects/GothicLlamasFE/selenium_test/src/main/java/us001_selenium_test/ocular_snpshot";
        Ocular.config()
                .resultPath(Paths.get(resultPath))
                .snapshotPath(Paths.get(snapshotPath))
                .globalSimilarity(95)
                .saveSnapshot(true);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}