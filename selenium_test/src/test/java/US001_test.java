import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTest;

public class US001_test extends FunctionalTest {

    @Test
    public void isJobRolePageExist_TC01(){
        String indexPageUrl = "http://localhost:7999/";
        String jobRolePageUrl = "http://localhost:7999/job-roles";
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.cssSelector("body:nth-child(2) div.header:nth-child(1) div.inline:nth-child(2) > a:nth-child(1)"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL );
        System.out.println(URL);
    }

    @Test
    public void isJobRolePageLooksLikeShould_TC02(){

    }

}
