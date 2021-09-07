package chrome;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestChrome;

public class US001_chrome_test extends FunctionalTestChrome {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageWorkingCorrectly_TC01() {
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL);
    }

    @Test
    public void isJobRolePageContentIsShow_TC02() {
        driver.get(jobRolePageUrl);
        //Find page element div class named "roles"
        WebElement roles = driver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobRolePageBannerIsShow_TC03() {
        driver.get(jobRolePageUrl);
        //Find page banner
        By xpathJobRolePageBanner = By.xpath("//h1[contains(text(),'Job Roles within Kainos')]");
        WebElement jobRolePageBanner = driver.findElement(xpathJobRolePageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobRolePageBanner);

    }

}
