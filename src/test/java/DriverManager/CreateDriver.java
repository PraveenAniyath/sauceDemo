package DriverManager;

import Helpers.HelperFunctions;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CreateDriver {

    HelperFunctions helper = new HelperFunctions();
    public WebDriver driver ;

    public WebDriver createDriver() throws IOException {
        String browser = getBrowserType();
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")+"\\WebDrivers\\Chrome\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-popup-blocking");
             driver = new ChromeDriver(options);
            BasePage page = new BasePage();
            page.setWebDriver(driver);
            driver.manage().deleteAllCookies();
            helper.setImplicitwait(driver,5);
        }
        return driver;
    }

    private String getBrowserType() throws IOException {

        String browser = (String) helper.getPropertyFile().get("browser");
        return browser;
    }
}
