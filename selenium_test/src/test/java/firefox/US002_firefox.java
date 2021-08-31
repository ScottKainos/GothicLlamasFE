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
    public void isJobSpecPageExist_TC01() {
        firefoxDriver.get(indexPageUrl);
        WebElement jobRoleLink = firefoxDriver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = firefoxDriver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
        System.out.println(URL);
    }

    @Test
    public void isJobSpecPageLooksLikeItShould_TC02() {
        firefoxDriver.get(jobSpecPageUrl);
        List<WebElement> listOfElements = firefoxDriver.findElements(By.tagName("th"));
        // Check if we got a list of 32 elements
        Assert.assertEquals(3, listOfElements.size());
        // Check if first column is "Job Role"
        Assert.assertEquals("Job Role", listOfElements.get(0).getText());
        // Check if second column is "Job Description"
        Assert.assertEquals("Job Description", listOfElements.get(1).getText());
        // Check if third column is "Job Specification"
        Assert.assertEquals("Job Specification", listOfElements.get(2).getText());
        // Print all columns name from list
        System.out.println("Found this many columns: " + listOfElements.size());
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Column name: " + listOfElements.get(i).getText());
        }
        // Check how many rows are in the table
        List<WebElement> listOfElementsOfTable = firefoxDriver.findElements(By.tagName("td"));
        int rowsInTable = listOfElementsOfTable.size() / 3;
        System.out.printf("Found this many rows: " + rowsInTable);
    }

    @Test
    public void isJobSpecPageLinksAreCorrect_TC03() {
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

