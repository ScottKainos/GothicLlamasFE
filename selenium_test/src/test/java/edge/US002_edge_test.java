package edge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;

import java.util.List;

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
        System.out.println(URL);
    }

    @Test
    public void isJobSpecPageContentIsShow_TC02() {
        edgeDriver.get(jobSpecPageUrl);
        //Find page content
        WebElement jobSpecPageContent = edgeDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(jobSpecPageContent);

        //Shows how many columns are in the table
        List<WebElement> listOfElements = edgeDriver.findElements(By.tagName("th"));
        System.out.println("Found this many columns: " + listOfElements.size());
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Column name: " + listOfElements.get(i).getText());
        }

        //Shows how many rows are in the table
        List<WebElement> listOfElementsOfTable = edgeDriver.findElements(By.tagName("td"));
        int rowsInTable = listOfElementsOfTable.size() /listOfElements.size() ;
        System.out.printf("Found this many rows: " + rowsInTable);
    }

    @Test
    public void isJobSpecPageLinksAreWorking_TC03() {
        // Chose first link in table
        edgeDriver.get(jobSpecPageUrl);
        WebElement linkFrom1RowInTable = edgeDriver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]"));
        linkFrom1RowInTable.click();
        String URL1FromTable = edgeDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);

        // Chose ten link in table
        edgeDriver.get(jobSpecPageUrl);
        WebElement linkFrom10RowInTable = edgeDriver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]"));
        linkFrom10RowInTable.click();
        String URL10FromTable = edgeDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);
    }
}
