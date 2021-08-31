package firefox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

import java.util.List;

public class US001_firefox extends FunctionalTestFirefox {

    private static String indexPageUrl = "http://localhost:7999/";
    private static String jobRolePageUrl = "http://localhost:7999/job-roles";

    @Test
    public void isJobRolePageExist_TC01(){
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Roles"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobRolePageUrl, URL );
        System.out.println(URL);
    }

    @Test
    public void isJobRolePageLooksLikeItShould_TC02(){
        firefoxDriver.get(jobRolePageUrl);
        List<WebElement> listOfElements = firefoxDriver.findElements(By.tagName("p"));
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
