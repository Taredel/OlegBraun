package hw3;

import hw3.enums.HomePageData;
import hw3.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class PageObjectDesignTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void mainPageTest() {

        //1 open site by URL
        indexPage.open(HomePageData.INDEX_HTML_URL);

        //2 assert Browser title
        indexPage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //3 log in using certain userID-password
        indexPage.login(Users.PETER);

        //4 assert that username is displayed and has a proper value
        indexPage.checkUsername(Users.PETER);

        //5 assert Browser title
        indexPage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //6 assert that there are 4 items on the header section, they are displayed and they have proper names
        indexPage.checkHeaderSection();

        //7 assert that there are 4 images on the Index page and they are displayed
        indexPage.checkImages();

        //8 assert that there is text under of each icon on the Index page and each text is proper
        indexPage.checkTextUnderImages();

        //9 assert text of the main header
        indexPage.checkMainHeaderTexts();

        //10 assert that there is the iframe in the main page
        indexPage.checkIFrame();

        //11 switch to the iframe and check that there is EPAM logo in the left top corner of iframe, then switch back
        indexPage.checkEpamLogoIFrame();

        //12 assert a text of the sub header
        indexPage.checkSubHeaderText();

        //13 assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkJdiGithub(HomePageData.JDI_GITHUB_LINK);

        //14 assert that there is Left Section
        indexPage.checkLeftSection();

        //15 assert that there is Footer
        indexPage.checkFooter();
    }
}