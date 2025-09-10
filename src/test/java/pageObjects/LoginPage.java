package pageObjects;


import java.util.List;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class LoginPage {
    WebDriver driver;
    CommonUtils utils;
    public LoginPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        this.utils = new CommonUtils(DriverFactory.getDriver());
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID,using = "email")
    private WebElement txtbx_Email;

    @FindBy(how = How.ID, using = "password")
    private WebElement txtbx_Password;


    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign in')]")
    private WebElement btn_SignIn;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'menu-button')]")
    private List<WebElement> btn_Profile;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Log out')]")
    private WebElement btn_Logout;

    public void signIn(String email, String password) {
        utils.clickElement(btn_SignIn, 10);
        utils.enterText(txtbx_Email, email, 10);
        utils.enterText(txtbx_Password, password, 10);
        utils.clickElement(btn_SignIn, 10);
    }

    public void logout() throws InterruptedException {
        utils.clickElement(btn_Profile.get(1), 10);
        Thread.sleep(1000); // Adding a short wait to ensure the dropdown is visible
        utils.clickElementUsingActions(btn_Logout);
        utils.clickElement(btn_Profile.get(1), 10);
        Thread.sleep(1000); // Adding a short wait to ensure the dropdown is visible
        utils.clickElementUsingActions(btn_Logout);
    }

}
