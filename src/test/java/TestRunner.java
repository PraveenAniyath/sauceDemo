import DriverManager.BaseTestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "StepDefinition",
        plugin = {"junit:target/cucumber-junit.xml",
        "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber/cucumber.json"},
        tags = "@SauceLabE2E")

@RunWith(Cucumber.class)
public class TestRunner extends BaseTestRunner {}