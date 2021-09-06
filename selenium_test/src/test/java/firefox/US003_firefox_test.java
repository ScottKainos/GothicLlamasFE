package firefox;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

import java.util.List;

public class US003_firefox_test extends FunctionalTestFirefox {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String capabilitiesPageUrl = "http://localhost:7999/job-capabilities";

    @Test
    public void isCapabilitiesPageWorkingCorrectly_TC01() {
        firefoxDriver.get(indexPageUrl);
        WebElement capabilitiesPage = firefoxDriver.findElement(By.linkText("Capabilities"));
        capabilitiesPage.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(capabilitiesPageUrl, URL);

    }

    @Test
    public void isCapabilitiesPageContentIsShow_TC02() {
        firefoxDriver.get(capabilitiesPageUrl);
        //Find page content
        WebElement capabilitiesContent = firefoxDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(capabilitiesContent);

    }

}
