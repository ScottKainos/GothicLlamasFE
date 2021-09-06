package firefox;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

public class US001_firefox_test extends FunctionalTestFirefox {

    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageWorkingCorrectly_TC01() {
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL);
    }

    @Test
    public void isJobRolePageContentIsShow_TC02() {
        firefoxDriver.get(jobRolePageUrl);
        //Find page element div class named "roles"
        WebElement roles = firefoxDriver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobRolePageBannerIsShow_TC03() {
        firefoxDriver.get(jobRolePageUrl);
        //Find page banner
        By xpathJobRolePageBanner = By.xpath("//h1[contains(text(),'Job Roles within Kainos')]");
        WebElement jobRolePageBanner = firefoxDriver.findElement(xpathJobRolePageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobRolePageBanner);

    }
}
