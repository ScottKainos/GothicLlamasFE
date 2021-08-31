package chrome;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTest;

public class US001_test extends FunctionalTest {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageExist_TC01(){
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL );
        System.out.println(URL);
    }

    @Test
    public void isJobRolePageLooksLikeItShould_TC02(){
        driver.get(jobRolePageUrl);
        List<WebElement> listOfElements = driver.findElements(By.tagName("p"));
        // Check if we got a list of 32 elements
        Assert.assertEquals(32, listOfElements.size());
        // Check if first row is "Software Engineer"
        Assert.assertEquals("Software Engineer",listOfElements.get(0).getText());
        // Check if eleventh row is "Cloud Migration Architect"
        Assert.assertEquals("Cloud Migration Architect",listOfElements.get(10).getText());
        // Print all element from list
        System.out.println("Found paragraphs: " +listOfElements.size());
        for (int i=0; i<listOfElements.size();i++){
            System.out.println("Paragraph text: " + listOfElements.get(i).getText());
        }

    }

}
