package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;
    public void setWebDriver(WebDriver driver) {
        BasePage.driver =driver;
    }
}
