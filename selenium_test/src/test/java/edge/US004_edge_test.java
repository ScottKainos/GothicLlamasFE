package edge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestEdge;

public class US004_edge_test extends FunctionalTestEdge {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String bandLevelsPageUrl = "http://localhost:7999/band-levels";

    @Test
    public void isBandLevelsPageWorkingCorrectly_TC01() {
        edgeDriver.get(indexPageUrl);
        WebElement bandLevelPage = edgeDriver.findElement(By.linkText("Band Levels"));
        bandLevelPage.click();
        String URL = edgeDriver.getCurrentUrl();
        Assert.assertEquals(bandLevelsPageUrl, URL);
    }

    @Test
    public void isBandLevelsPageContentIsShow_TC02() {
        edgeDriver.get(bandLevelsPageUrl);
        //Find page content
        WebElement bandLevelsContent = edgeDriver.findElement(By.className("roles-per-band"));
        //Check if page content isn't NULL
        Assert.assertNotNull(bandLevelsContent);
    }

    @Test
    public void isBandLevelsBannerIsShow_TC03(){
        edgeDriver.get(bandLevelsPageUrl);
        //Find page banner
        By xpathPageBanner = By.xpath("//h1[contains(text(),'Job Roles Per Band')]");
        WebElement bandLevelsPageBanner = edgeDriver.findElement(xpathPageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(bandLevelsPageBanner);
    }
}
