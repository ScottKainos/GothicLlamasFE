package firefox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestFirefox;

import java.util.List;

public class US002_firefox extends FunctionalTestFirefox {

    private String indexPageUrl = "http://localhost:7999";
    private String jobSpecPageUrl = "http://localhost:7999/job-spec";

    @Test
    public void isJobSpecPageWorkingCorrectly_TC01() {
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
        System.out.println(URL);
    }

    @Test
    public void isJobSpecPageContentIsShow_TC02() {
        firefoxDriver.get(jobSpecPageUrl);
        //Find page content
        WebElement jobSpecPageContent = firefoxDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(jobSpecPageContent);

        //Shows how many columns are in the table
        List<WebElement> listOfElements = firefoxDriver.findElements(By.tagName("th"));
        System.out.println("Found this many columns: " + listOfElements.size());
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Column name: " + listOfElements.get(i).getText());
        }

        //Shows how many rows are in the table
        List<WebElement> listOfElementsOfTable = firefoxDriver.findElements(By.tagName("td"));
        int rowsInTable = listOfElementsOfTable.size() /listOfElements.size() ;
        System.out.printf("Found this many rows: " + rowsInTable);
    }

    @Test
    public void isJobSpecPageLinksAreWorking_TC03() {
        // Chose first link in table
        firefoxDriver.get(jobSpecPageUrl);
        WebElement linkFrom1RowInTable = firefoxDriver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]"));
        linkFrom1RowInTable.click();
        String URL1FromTable = firefoxDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);

        // Chose ten link in table
        firefoxDriver.get(jobSpecPageUrl);
        WebElement linkFrom10RowInTable = firefoxDriver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]"));
        linkFrom10RowInTable.click();
        String URL10FromTable = firefoxDriver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);
    }

}

