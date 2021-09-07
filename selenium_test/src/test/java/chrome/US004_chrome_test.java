package chrome;

import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import us_selenium_test.framework.FunctionalTestChrome;

public class US004_chrome_test extends FunctionalTestChrome {
    private static String indexPageUrl = "http://localhost:7999/";
    private static String bandLevelsPageUrl = "http://localhost:7999/band-levels";

    @Test
    public void isBandLevelsPageWorkingCorrectly_TC01() {
        driver.get(indexPageUrl);
        WebElement bandLevelPage = driver.findElement(By.linkText("Band Levels"));
        bandLevelPage.click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(bandLevelsPageUrl, URL);
    }

    @Test
    public void isBandLevelsPageContentIsShow_TC02() {
        driver.get(bandLevelsPageUrl);
        //Find page content
        WebElement bandLevelsContent = driver.findElement(By.className("roles-per-band"));
        //Check if page content isn't NULL
        Assert.assertNotNull(bandLevelsContent);
    }

    @Test
    public void isBandLevelsBannerIsShow_TC03(){
        driver.get(bandLevelsPageUrl);
        //Find page banner
        By xpathPageBanner = By.xpath("//h1[contains(text(),'Job Roles Per Band')]");
        WebElement bandLevelsPageBanner = driver.findElement(xpathPageBanner);
        //Check if page banner isn't NULL
        Assert.assertNotNull(bandLevelsPageBanner);
    }
}
