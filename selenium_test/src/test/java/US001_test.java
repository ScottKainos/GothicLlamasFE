import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us001_selenium_test.framework.FunctionalTest;

public class US001_test extends FunctionalTest {

    private String indexPageUrl = "http://localhost:7999";
    private String jobPageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageExist(){
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobPageUrl, URL );
        System.out.println(URL);
    }



}
