package Pages;


import Helpers.HelperFunctions;
import Helpers.Reports;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverViewPage {
    ;
    HelperFunctions helper = new HelperFunctions();
    Reports reports = new Reports();
    WebDriver driver;

    public CheckoutOverViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page Elements

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement CheckoutOverviewPageTitle;

    @FindBy(xpath = "//button[@name='finish']")
    private WebElement Finishbutton;


    public void verifyCheckoutOverviewPage() {
      helper.waitforElementTobeDisplayed(driver, CheckoutOverviewPageTitle);
        if (CheckoutOverviewPageTitle.isDisplayed())
            Assert.assertTrue(true);
        else
            Assert.fail();
    }

    public void clickFinish() {
        Finishbutton.click();
    }
}

