package Pages;


import DriverManager.CreateDriver;
import Helpers.HelperFunctions;
import Helpers.Reports;
import io.cucumber.java.Scenario;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LoginPage {
    CreateDriver webDriverManager = new CreateDriver();
    WebDriver driver;
    HelperFunctions helper = new HelperFunctions();
    Reports reports = new Reports();
    ProductsPage productsPage;

    public LoginPage() throws IOException {
       this.driver =    webDriverManager.createDriver();
        PageFactory.initElements(driver, this);
    }

    //page Elements

    @FindBy(xpath ="//div[@class='login_logo' and text()='Swag Labs']")
    private WebElement loginPageTitle;

    @FindBy(xpath ="//input[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath ="//input[@id='password']")
    private WebElement password;

    @FindBy(xpath ="//input[@id='login-button']")
    private WebElement loginButton;


    public void launchURL(String testname) throws IOException, InterruptedException {
        String url = helper.getURL();
        driver.get(url);
        helper.waitUntilpageload(driver,20);
        File path = helper.takeScreenshot(driver,"Landing page displayed successfully");
        reports.createReport(testname, Scenario.class.getName());
    }

    public void verifyLanding() throws IOException {
        if(loginPageTitle.isDisplayed())
            Assert.assertTrue(true);
        else {
            helper.takeScreenshot(driver,"Landing page displayed successfully");
            Assert.fail();
        }
    }


    public void loginToapplication(String user) {
        userName.clear();
        userName.sendKeys(user);
        password.clear();
        password.sendKeys("secret_sauce");
        loginButton.click();
    }
}
