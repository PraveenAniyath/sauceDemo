package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HelperFunctions {

    public Properties getPropertyFile()
    {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\Application.properties");
            prop = new Properties();
            prop.load(fis);
        } catch(IOException fnfe) {
            fnfe.printStackTrace();
        }
        return  prop;
    }

    public String getURL() {
        String Url = (String) getPropertyFile().get("appURL");
        return Url;
    }

    public void setImplicitwait(WebDriver driver, int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

    }

    public File takeScreenshot(WebDriver driver,String filename) throws IOException {
        File sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+filename.replace(" ","")+".png");
        FileUtils.copyFile(sourcePath,destFile);
        return destFile;
    }

    public void waitUntilpageload(WebDriver driver, int waitTime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isPageLoaded = false;

         for(int i =0;i<waitTime;i++)
         {
             isPageLoaded = (Boolean) js.executeScript("return document.readyState === 'complete';");
             if (isPageLoaded)
                 break;
             else
             {
                 Thread.sleep(1000);
             }
         }
    }

    public void waitforElementTobeDisplayed(WebDriver driver, WebElement productsPageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(productsPageTitle));
    }
}
