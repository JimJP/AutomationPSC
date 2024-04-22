package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pageObjects.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/features",
        glue = "stepsDefinitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
        tags = "@AdministracionMenus" //Sirve para ejecutar solo los test con dicho nombre
)

public class Runner {
    @AfterClass
    public static void cerrarBrowser() {
        BasePage.closeBrowser();
    }
}
