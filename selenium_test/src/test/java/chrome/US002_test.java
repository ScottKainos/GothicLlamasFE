package chrome;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTest;

import java.util.List;

public class US002_test extends FunctionalTest {
    private String indexPageUrl = "http://localhost:7999";
    private String jobSpecPageUrl = "http://localhost:7999/job-spec";

    @Test
    public void isJobSpecPageExist_TC01() {
        driver.get(indexPageUrl);
        WebElement jobRoleLink = driver.findElement(By.linkText("Job Specification"));
        jobRoleLink.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(jobSpecPageUrl, URL);
        System.out.println(URL);
    }

    @Test
    public void isJobSpecPageLooksLikeItShould_TC02() {
        driver.get(jobSpecPageUrl);
        List<WebElement> listOfElements = driver.findElements(By.tagName("th"));
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
        List<WebElement> listOfElementsOfTable = driver.findElements(By.tagName("td"));
        int rowsInTable = listOfElementsOfTable.size() /3 ;
        System.out.printf("Found this many rows: " + rowsInTable);
    }

    @Test
    public void isJobSpecPageLinksAreCorrect_TC03() {
        // Chose first link in table
        driver.get(jobSpecPageUrl);
        WebElement linkFrom1RowInTable = driver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]"));
        linkFrom1RowInTable.click();
        String URL1FromTable = driver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL1FromTable);

        // Chose ten link in table
        driver.get(jobSpecPageUrl);
        WebElement linkFrom10RowInTable = driver.findElement(By.xpath("//body[1]/div[3]/table[1]/tbody[10]/tr[1]/td[3]/a[1]"));
        linkFrom10RowInTable.click();
        String URL10FromTable = driver.getCurrentUrl();
        // Check if the URL has changed
        Assert.assertNotSame(jobSpecPageUrl, URL10FromTable);
    }

}
