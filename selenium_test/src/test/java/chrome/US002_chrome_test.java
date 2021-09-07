package chrome;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestChrome;

public class US002_chrome_test extends FunctionalTestChrome {
    private String indexPageUrl = "http://localhost:7999";
    private String jobSpecPageUrl = "http://localhost:7999/job-spec";

    @Test
    public void isJobSpecPageWorkingCorrectly_TC01() {
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
    }

    @Test
    public void isJobSpecPageContentIsShow_TC02() {
        driver.get(jobSpecPageUrl);
        //Find page element div class named "roles"
        WebElement roles = driver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobSpecPageFirstLinkIsWorking_TC03() {
        // Chose first link in table
        driver.get(jobSpecPageUrl);
        By xpathForFirstLink = By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]");
        WebElement linkFrom1RowInTable = driver.findElement(xpathForFirstLink);
        linkFrom1RowInTable.click();
        String URL1FromTable = driver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);
    }

    @Test
    public void isJobSpecPageTenLinkIsWorking_TC04() {
        // Chose ten link in table
        driver.get(jobSpecPageUrl);
        By xpathForTenLink = By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]");
        WebElement linkFrom10RowInTable = driver.findElement(xpathForTenLink);
        linkFrom10RowInTable.click();
        String URL10FromTable = driver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);

    }

    @Test
    public void isJobSpecPageBannerIsShow_TC05(){
        driver.get(jobSpecPageUrl);
        //Find page banner
        By xpathJobSpecPageBanner = By.xpath("//h1[contains(text(),'Job Role Specification')]");
        WebElement jobSpecPageBanner = driver.findElement(xpathJobSpecPageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobSpecPageBanner);

    }
}


