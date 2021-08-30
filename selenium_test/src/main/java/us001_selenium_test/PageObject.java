package us001_selenium_test;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Paths;

public class PageObject {

    private final WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}