package edge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;


public class US002_edge_test extends FunctionalTestEdge {
    private String indexPageUrl = "http://localhost:7999";
    private String jobSpecPageUrl = "http://localhost:7999/job-spec";

    @Test
    public void isJobSpecPageWorkingCorrectly_TC01() {
        edgeDriver.get(indexPageUrl);
        WebElement jobRoleLink = edgeDriver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = edgeDriver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
    }

    @Test
    public void isJobSpecPageContentIsShow_TC02() {
        edgeDriver.get(jobSpecPageUrl);
        //Find page element div class named "roles"
        WebElement roles = edgeDriver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobSpecPageFirstLinkIsWorking_TC03() {
        // Chose first link in table
        edgeDriver.get(jobSpecPageUrl);
        By xpathForFirstLink = By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]");
        WebElement linkFrom1RowInTable = edgeDriver.findElement(xpathForFirstLink);
        linkFrom1RowInTable.click();
        String URL1FromTable = edgeDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);
    }

    @Test
    public void isJobSpecPageTenLinkIsWorking_TC04() {
        // Chose ten link in table
        edgeDriver.get(jobSpecPageUrl);
        By xpathForTenLink = By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]");
        WebElement linkFrom10RowInTable = edgeDriver.findElement(xpathForTenLink);
        linkFrom10RowInTable.click();
        String URL10FromTable = edgeDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);

    }

    @Test
    public void isJobSpecPageBannerIsShow_TC05(){
        edgeDriver.get(jobSpecPageUrl);
        //Find page banner
        By xpathJobSpecPageBanner = By.xpath("//h1[contains(text(),'Job Role Specification')]");
        WebElement jobSpecPageBanner = edgeDriver.findElement(xpathJobSpecPageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobSpecPageBanner);

    }
}
