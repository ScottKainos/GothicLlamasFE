package edge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;

import java.util.List;

public class US003_edge_test extends FunctionalTestEdge {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String capabilitiesPageUrl = "http://localhost:7999/job-capabilities";

    @Test
    public void isCapabilitiesPageWorkingCorrectly_TC01() {
        edgeDriver.get(indexPageUrl);
        WebElement capabilitiesPage = edgeDriver.findElement(By.linkText("Capabilities"));
        capabilitiesPage.click();
        String URL = edgeDriver.getCurrentUrl();
        Assert.assertEquals(capabilitiesPageUrl, URL);
        System.out.println(URL);
    }

    @Test
    public void isCapabilitiesPageContentIsShow_TC02() {
        edgeDriver.get(capabilitiesPageUrl);
        //Find page content
        WebElement capabilitiesContent = edgeDriver.findElement(By.xpath("//body/div[3]"));
        //Check if page content isn't NULL
        Assert.assertNotNull(capabilitiesContent);

        //Shows how many columns are in the table
        List<WebElement> listOfElements = edgeDriver.findElements(By.tagName("th"));
        System.out.println("Found this many columns: " + listOfElements.size());
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println("Column name in Capabilities Table: " + listOfElements.get(i).getText());
        }

        //Shows how many rows are in the table
        List<WebElement> listOfElementsOfTable = edgeDriver.findElements(By.tagName("td"));
        int rowsInTable = listOfElementsOfTable.size() / listOfElements.size();
        System.out.printf("Found this many rows in Capabilities Table: " + rowsInTable);
    }

}
