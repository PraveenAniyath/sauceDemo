package Pages;


import Helpers.HelperFunctions;
import Helpers.Reports;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CartPage {
    ;
    HelperFunctions helper = new HelperFunctions();
    Reports reports = new Reports();
    WebDriver driver;
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page Elements

    @FindBy(xpath ="//div[@class='inventory_item_name']")
    private List<WebElement> productList;

    @FindBy(xpath ="//button[@id='checkout']")
    private WebElement checkout;

    @FindBy(xpath ="//span[text()='Your Cart']")
    private WebElement CartPageTitle;

    public void verifyProductsinCartpage(List<String> prod) throws IOException {

        boolean product = false;
        for(int i = 0; i < productList.size(); i++)
        {
            for(int j = 0; j < prod.size(); j++)
            {
                if(productList.get(i).getText().trim().equals(prod.get(j).trim())) {
                    product = true;
                    break;
                }
                else
                {
                    if(j==prod.size()-1) {
                        helper.takeScreenshot(driver,"Products are not added to carts page");
                        Assert.fail();
                    }
                }
            }
        }

    }

    public void clickCheckout() {
        checkout.click();
    }

    public void verifyCartsPage() throws IOException {
       helper.waitforElementTobeDisplayed(driver, CartPageTitle);
        if(CartPageTitle.isDisplayed())
            Assert.assertTrue(true);
        else {
            helper.takeScreenshot(driver,"Carts page is not displayed");
            Assert.fail();
        }
    }

    public void removeProductsfromCart(List<String> prod) {
        for(String product : prod)
        {
            WebElement element =driver.findElement(By.xpath(" //*[text()='"+product+"']//ancestor::div[@class='cart_item']//button"));
            element.click();
        }
    }
}
