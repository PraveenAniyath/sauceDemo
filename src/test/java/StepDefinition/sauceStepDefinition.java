package StepDefinition;

import DriverManager.CreateDriver;
import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class sauceStepDefinition extends BasePage {

    LoginPage loginPage ;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverViewPage checkoutOverViewPage;
    public sauceStepDefinition() throws IOException {
        loginPage =new LoginPage();
        productsPage=new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverViewPage =new CheckoutOverViewPage(driver);
    }

    @Given("launch the sauce demo url for Test {string}")
    public void launchTheSauceDemoUrl(String testname) throws IOException, InterruptedException {
        loginPage.launchURL(testname);
    }

    @When("Login in to the application for user {string}")
    public void loginInToTheApplicationForUser(String user) {
        loginPage.loginToapplication(user);
    }

    @Then("verify if login page is displayed successfully")
    public void verifyIfLandingPageIsDisplayedSuccessfully() throws IOException {
        loginPage.verifyLanding();
    }

    @And("verify if products page is displayed successfully")
    public void verifyIfProductsPageIsDisplayedSuccessfully() throws IOException {
        productsPage.verifyProductsPage();
    }

    @And("add product to the cart")
    public void addProductToTheCart(DataTable products) {
        List<String> prod = products.asList();
        productsPage.addProductToCart(prod);
    }

    @And("Click cart icon")
    public void clickCartIcon() {
        productsPage.clickCartIcon();
    }

    @Then("verify if cart is loaded with added items")
    public void verifyIfCartIsLoadedWithAddedItems(DataTable products) throws IOException {
        List<String> prod = products.asList();
        cartPage.verifyProductsinCartpage(prod);
    }

    @And("click on checkout button")
    public void clickOnCheckoutButton() {
        cartPage.clickCheckout();

    }

    @Then("verify if cart page is displayed successfully")
    public void verifyIfCartPageIsDisplayedSuccessfully() throws IOException {
        cartPage.verifyCartsPage();

    }

    @Then("verify if checkout page is displayed successfully")
    public void verifyIfCheckoutPageIsDisplayedSuccessfully() {
        checkoutPage.verifyCheckoutPage();
    }

    @And("user inputs firstname as {string} , lastname as {string} and zipcode as {string}")
    public void userInputsFirstnameAsLastnameAsAndZipcodeAs(String fname, String lname, String zipcode) {
        checkoutPage.inputCheckoutdetails(fname,lname,zipcode);
    }

    @And("click on continue shopping button")
    public void clickOnContinueShoppingButton() {
        checkoutPage.clickContinueShopping();

    }

    @And("remove products from the cart")
    public void removeProductsFromTheCart(DataTable products) {
        List<String> prod = products.asList();
        cartPage.removeProductsfromCart(prod);
    }

    @Then("verify if checkout overview page is displayed successfully")
    public void verifyIfCheckoutOverviewPageIsDisplayedSuccessfully() {
        checkoutOverViewPage.verifyCheckoutOverviewPage();
    }

    @And("click on Finish button")
    public void clickOnFinishButton() {
        checkoutOverViewPage.clickFinish();
    }
}
