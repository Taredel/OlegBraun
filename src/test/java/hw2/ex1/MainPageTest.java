package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This class is testing web page with URL "https://epam.github.io/JDI/" using @dataProviders with parallel settings.
 *
 * @author Oleg Braun
 * @version 1.2 29 Jan 2019
 */

public class MainPageTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @DataProvider(name = "dp", parallel = true)
    private Object[][] dataProviderWithProperTexts() {
        return new String[][]{
                {"div.main-content > div > div:nth-child(1)", "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {"div.main-content > div > div:nth-child(2)", "To be flexible and\n" + "customizable"},
                {"div.main-content > div > div:nth-child(3)", "To be multiplatform"},
                {"div.main-content > div > div:nth-child(4)", "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProviderClass = MainPageTest.class, dataProvider = "dp")
    public void checkTextUnderImages(String cssLink, String expectedText) {

        //assert that text under each image is proper
        assertEquals(driver.findElement(By.cssSelector(cssLink)).getText(), expectedText);

    }
}