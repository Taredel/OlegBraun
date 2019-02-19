package hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.java.uk.Нехай;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }
}
