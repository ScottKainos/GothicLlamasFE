package chrome;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestChrome;

import java.util.List;

public class US003_chrome_test extends FunctionalTestChrome {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String capabilitiesPageUrl = "http://localhost:7999/job-capabilities";

    @Test
    public void isCapabilitiesPageWorkingCorrectly_TC01() {
        driver.get(indexPageUrl);
        WebElement capabilitiesPage = driver.findElement(By.linkText("Capabilities"));
        capabilitiesPage.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(capabilitiesPageUrl, URL);
    }

    @Test
    public void isCapabilitiesPageContentIsShow_TC02() {
        driver.get(capabilitiesPageUrl);
        //Find page content
        WebElement capabilitiesContent = driver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(capabilitiesContent);
    }

}

