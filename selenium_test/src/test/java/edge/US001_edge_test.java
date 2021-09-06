package edge;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;

import java.util.List;

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
        System.out.println(URL);
    }

    @Test
    public void isJobRolePageContentIsShow_TC02() {
        edgeDriver.get(jobRolePageUrl);
        //Find page content
        WebElement jobRolePageContent = edgeDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(jobRolePageContent);
        //Shows how many items it has downloaded from the database
        List<WebElement> listOfElements = edgeDriver.findElements(By.tagName("p"));
        System.out.println("Found paragraphs: " + listOfElements.size());
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Paragraph text: " + listOfElements.get(i).getText());
        }
    }

}
