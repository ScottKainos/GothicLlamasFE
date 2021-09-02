package us_selenium_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    private final WebDriver driver;
    private final WebDriver firefoxDriver;
    //private final WebDriver safariDriver;
    private final WebDriver edgeDriver;

    public PageObject(WebDriver driver, WebDriver firefoxDriver, WebDriver safariDriver, WebDriver edgeDriver) {
        this.driver = driver;
        this.firefoxDriver = firefoxDriver;
        //this.safariDriver = safariDriver;
        this.edgeDriver = edgeDriver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(firefoxDriver, this);
        //PageFactory.initElements(safariDriver, this);
        PageFactory.initElements(edgeDriver, this);
    }

}