package Pages;


import Helpers.HelperFunctions;
import Helpers.Reports;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    ;
    HelperFunctions helper = new HelperFunctions();
    Reports reports = new Reports();
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page Elements

    @FindBy(xpath ="//span[text()='Checkout: Your Information']")
    private WebElement CheckoutPageTitle;

    @FindBy(xpath ="//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath ="//input[@id='last-name']")
    private WebElement LastName;

    @FindBy(xpath ="//input[@id='postal-code']")
    private WebElement zipCode;

    @FindBy(xpath ="//input[@id='continue']")
    private WebElement Continue;

    @FindBy(xpath ="//button[@id='continue-shopping']")
    private WebElement ContinueShopping;


    public void verifyCheckoutPage() {
        helper.waitforElementTobeDisplayed(driver, CheckoutPageTitle);
        if(CheckoutPageTitle.isDisplayed())
            Assert.assertTrue(true);
        else
            Assert.fail();
    }

    public void inputCheckoutdetails(String fname, String lname, String zipcode) {
        firstName.clear();
        firstName.sendKeys(fname.trim());
        LastName.clear();
        LastName.sendKeys(lname.trim());
        zipCode.clear();
        zipCode.sendKeys(zipcode.trim());
        Continue.click();
    }

    public void clickContinueShopping() {
        ContinueShopping.click();
    }
}
