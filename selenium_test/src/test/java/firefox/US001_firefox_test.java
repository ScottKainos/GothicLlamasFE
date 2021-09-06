package firefox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

import java.util.List;

public class US001_firefox_test extends FunctionalTestFirefox {

    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageWorkingCorrectly_TC01(){
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL );
    }

    @Test
    public void isJobRolePageContentIsShow_TC02(){
        firefoxDriver.get(jobRolePageUrl);
        //Find page content
        WebElement pageContent = firefoxDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(pageContent);

    }
}
