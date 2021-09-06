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
        //Find page content
        WebElement jobRolePageContent = edgeDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(jobRolePageContent);

    }

}
