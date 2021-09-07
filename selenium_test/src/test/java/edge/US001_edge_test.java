package edge;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;

public class US001_edge_test extends FunctionalTestEdge {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageWorkingCorrectly_TC01() {
        edgeDriver.get(indexPageUrl);
        WebElement jobRoleLink = edgeDriver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = edgeDriver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL);
    }

    @Test
    public void isJobRolePageContentIsShow_TC02() {
        edgeDriver.get(jobRolePageUrl);
        //Find page element div class named "roles"
        WebElement roles = edgeDriver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobRolePageBannerIsShow_TC03() {
        edgeDriver.get(jobRolePageUrl);
        //Find page banner
        By xpathJobRolePageBanner = By.xpath("//h1[contains(text(),'Job Roles within Kainos')]");
        WebElement jobRolePageBanner = edgeDriver.findElement(xpathJobRolePageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobRolePageBanner);

    }

}
