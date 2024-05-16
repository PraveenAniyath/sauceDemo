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

public class ProductsPage {
    ;
    HelperFunctions helper = new HelperFunctions();
    Reports reports = new Reports();
    WebDriver driver;
    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //page Elements

    @FindBy(xpath ="//span[@class='title' and text()='Products']")
    private WebElement ProductsPageTitle;

    @FindBy(xpath ="//a[@class='shopping_cart_link']")
    private WebElement Carticon;

    public void verifyProductsPage() throws IOException {
        helper.waitforElementTobeDisplayed(driver,ProductsPageTitle);
        if(ProductsPageTitle.isDisplayed())
            Assert.assertTrue(true);
        else {
            helper.takeScreenshot(driver,"Product page is not displayed ");
            Assert.fail();
        }
    }


    public void addProductToCart(List<String> prod) {

        for(String product : prod)
        {
            WebElement element =driver.findElement(By.xpath(" //*[text()='"+product+"']//ancestor::div[@class='inventory_item']//button"));
            element.click();
        }

    }

    public void clickCartIcon() {
        Carticon.click();
    }


}
