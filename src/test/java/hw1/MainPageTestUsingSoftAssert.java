package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.System.setProperty;

public class MainPageTestUsingSoftAssert {
    private WebDriver driver;
    private SoftAssert softAssertion = new SoftAssert();

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void mainPageTestUsingSoftAssert() {

        //1 open site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 assert Browser title
        softAssertion.assertEquals(driver.getTitle(), "Home"); //this test will fail on purpose to see that SoftAssert works.

        //3 log in using certain userID-password
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 assert that username is displayed and has a proper value
        softAssertion.assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 assert Browser title
        softAssertion.assertEquals(driver.getTitle(), "Home Page");

        //6 assert that there are 4 items on the header section, they are displayed and they have proper names
        softAssertion.assertEquals(driver.findElements(By.cssSelector("ul.m-l8 > li")).size(), 4); //assert number of header sections

        softAssertion.assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(1) > a")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(1) > a")).getText(), "HOME" );

        softAssertion.assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(2) > a")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(2) > a")).getText(), "CONTACT FORM" );

        softAssertion.assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(3) > a")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(3) > a")).getText(), "SERVICE" );

        softAssertion.assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(4) > a")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(4) > a")).getText(), "METALS & COLORS" );

        //7 assert that there are 4 images on the Index page and they are displayed
        softAssertion.assertEquals(driver.findElements(By.cssSelector("div.main-content > div > div")).size(),4);
        softAssertion.assertTrue(driver.findElement(By.cssSelector("span.icon-practise")).isDisplayed());
        softAssertion.assertTrue(driver.findElement(By.cssSelector("span.icon-custom")).isDisplayed());
        softAssertion.assertTrue(driver.findElement(By.cssSelector("span.icon-multi")).isDisplayed());
        softAssertion.assertTrue(driver.findElement(By.cssSelector("span.icon-base")).isDisplayed());

        //8 assert that there is text under of each icon on the Index page and each text is proper
        softAssertion.assertEquals(driver.findElements(By.cssSelector("span.benefit-txt")).size(),4);

        softAssertion.assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1)")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1)")).getText(),
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project");

        softAssertion.assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2)")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2)")).getText(),
                "To be flexible and\n" + "customizable");

        softAssertion.assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3)")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3)")).getText(),
                "To be multiplatform");

        softAssertion.assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4")).isDisplayed());
        softAssertion.assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4)")).getText(),
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 assert text of the main header
        softAssertion.assertEquals(driver.findElement(By.cssSelector("[name='main-title']")).getText().trim(),
                "EPAM FRAMEWORK WISHES…" );
        softAssertion.assertEquals(driver.findElement(By.cssSelector("[name='jdi-text']")).getText().trim(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                        "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                        "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                        "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR." );

        //10 assert that there is the iframe in the main page
        softAssertion.assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 switch to the iframe and check that there is EPAM logo in the left top corner of iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("[id='iframe']")));
        softAssertion.assertTrue(driver.findElement(By.cssSelector("[class='epam-logo']")).isDisplayed());

        //12 switching back to original window
        driver.switchTo().parentFrame();

        //13 assert a text of the sub header
        softAssertion.assertEquals(driver.findElement(By.cssSelector("[class='text-center']")).getText(),"JDI GITHUB" );

        //14 assert that JDI GITHUB is a link and has a proper URL
        softAssertion.assertNotNull(driver.findElement(By.cssSelector("div.main-content > h3:nth-child(3) > a"))
                .getAttribute("href"));
        softAssertion.assertEquals(driver.findElement(By.cssSelector("div.main-content > h3:nth-child(3) > a"))
                        .getAttribute("href"),"https://github.com/epam/JDI" );

        //15 assert that there is Left Section
        softAssertion.assertTrue(driver.findElement(By.cssSelector("[id='mCSB_1_container']")).isDisplayed());

        //16 assert that there is Footer
        softAssertion.assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());

        softAssertion.assertAll();
    }
}
