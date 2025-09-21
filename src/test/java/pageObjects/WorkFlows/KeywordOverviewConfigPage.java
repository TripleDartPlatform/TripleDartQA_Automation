package pageObjects.WorkFlows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class KeywordOverviewConfigPage {
    WebDriver driver;
    CommonUtils utils;

    public KeywordOverviewConfigPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);
    }
}