package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static org.openqa.selenium.devtools.v124.page.Page.captureScreenshot;

public class Reports {
    HelperFunctions helper = new HelperFunctions();
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;
    ExtentTest test;
    public void configReport()
    {
        sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);



    }
    public void createReport(String TestName, String TestDescription)
    {
        configReport();
        test = extent.createTest(TestName, TestDescription);
       // test.log(com.aventstack.extentreports.Status.INFO, "Open browser and navigate to login page");


        //String screenshotPath = System.getProperty("user.dir")+"\\target\\screenshots\\";
        // String screenshotPath = captureScreenshot();

    //    test.log(Status.PASS, "Login failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        //test.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());

        // End the test
        extent.flush();
    }

    public void addtestLog(String stepDescription,String status,String path)
    {
        if(status.equalsIgnoreCase("Info"))
            test.log(com.aventstack.extentreports.Status.INFO, stepDescription);
        else if(status.equalsIgnoreCase("Pass"))
            test.log(Status.PASS, stepDescription,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        else if(status.equalsIgnoreCase("Fail"))
            test.log(Status.FAIL, stepDescription,MediaEntityBuilder.createScreenCaptureFromPath(path).build());

    }
}
