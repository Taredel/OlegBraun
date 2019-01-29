package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

// TODO Pay attention on code convention, reformat this via IDEA.
public class MainPageTest {

    private WebDriver driver;

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
    public void mainPageTest() {

        //1 open site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 log in using certain userID-password
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 assert that username is displayed and has a proper value
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //5 assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 assert that there are 4 items on the header section, they are displayed and they have proper names
        assertEquals(driver.findElements(By.cssSelector("ul.m-l8 > li")).size(), 4); //assert number of header sections

        assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(1) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(1) > a")).getText(), "HOME" );

        assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(2) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(2) > a")).getText(), "CONTACT FORM" );

        assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(3) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(3) > a")).getText(), "SERVICE" );

        assertTrue(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(4) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("ul.m-l8 > li:nth-child(4) > a")).getText(), "METALS & COLORS" );

        //7 assert that there are 4 images on the Index page and they are displayed
        assertEquals(driver.findElements(By.cssSelector("div.main-content > div > div")).size(),4);
        assertTrue(driver.findElement(By.cssSelector("span.icon-practise")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("span.icon-custom")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("span.icon-multi")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("span.icon-base")).isDisplayed());

        //8 assert that there is text under of each icon on the Index page and each text is proper
        assertEquals(driver.findElements(By.cssSelector("span.benefit-txt")).size(),4);

        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(1)")).getText(),
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project");

        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(2)")).getText(),
                "To be flexible and\n" + "customizable");

        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3)")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(3)")).getText(),
                "To be multiplatform");

        assertTrue(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("div.main-content > div > div:nth-child(4)")).getText(),
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //9 assert text of the main header
        assertEquals(driver.findElement(By.cssSelector("[name='main-title']")).getText().trim(), "EPAM FRAMEWORK WISHES…" );
        assertEquals(driver.findElement(By.cssSelector("[name='jdi-text']")).getText().trim(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                        "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                        "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                        "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR." );

        //10 assert that there is the iframe in the main page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //11 switch to the iframe and check that there is EPAM logo in the left top corner of iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("[id='iframe']")));
        assertTrue(driver.findElement(By.cssSelector("[class='epam-logo']")).isDisplayed());

        //12 switching back to original window
        driver.switchTo().parentFrame();

        //13 assert a text of the sub header
        assertEquals(driver.findElement(By.cssSelector("[class='text-center']")).getText(),"JDI GITHUB" );

        //14 assert that JDI GITHUB is a link and has a proper URL
        assertNotNull(driver.findElement(By.cssSelector("div.main-content > h3:nth-child(3) > a")).getAttribute("href"));
        assertEquals(driver.findElement(By.cssSelector("div.main-content > h3:nth-child(3) > a")).getAttribute("href"),
                "https://github.com/epam/JDI" );

        //15 assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[id='mCSB_1_container']")).isDisplayed());

        //16 assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());
    }
}

