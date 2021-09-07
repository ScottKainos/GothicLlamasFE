package firefox;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

public class US002_firefox_test extends FunctionalTestFirefox {

    private String indexPageUrl = "http://localhost:7999";
    private String jobSpecPageUrl = "http://localhost:7999/job-spec";


    @Test
    public void isJobSpecPageWorkingCorrectly_TC01() {
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
    }

    @Test
    public void isJobSpecPageContentIsShow_TC02() {
        firefoxDriver.get(jobSpecPageUrl);
        //Find page element div class named "roles"
        WebElement roles = firefoxDriver.findElement(By.className("roles"));
        //Check if this element isn't NULL
        Assert.assertNotNull(roles);

    }

    @Test
    public void isJobSpecPageFirstLinkIsWorking_TC03() {
        // Chose first link in table
        firefoxDriver.get(jobSpecPageUrl);
        By xpathForFirstLink = By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]");
        WebElement linkFrom1RowInTable = firefoxDriver.findElement(xpathForFirstLink);
        linkFrom1RowInTable.click();
        String URL1FromTable = firefoxDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);
    }

    @Test
    public void isJobSpecPageTenLinkIsWorking_TC04() {
        // Chose ten link in table
        firefoxDriver.get(jobSpecPageUrl);
        By xpathForTenLink = By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]");
        WebElement linkFrom10RowInTable = firefoxDriver.findElement(xpathForTenLink);
        linkFrom10RowInTable.click();
        String URL10FromTable = firefoxDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);

    }

    @Test
    public void isJobSpecPageBannerIsShow_TC05(){
        firefoxDriver.get(jobSpecPageUrl);
        //Find page banner
        By xpathJobSpecPageBanner = By.xpath("//h1[contains(text(),'Job Role Specification')]");
        WebElement jobSpecPageBanner = firefoxDriver.findElement(xpathJobSpecPageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(jobSpecPageBanner);

    }

}

