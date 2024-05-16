package DriverManager;

import Pages.BasePage;
import io.cucumber.java.AfterAll;
import org.junit.AfterClass;

public class BaseTestRunner extends BasePage {
    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }


}
