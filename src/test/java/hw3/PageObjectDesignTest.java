package hw3;

import hw3.enums.HeaderSection;
import hw3.enums.BenefitTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.HomePageData.*;
import static hw3.enums.Users.PETER;
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
        indexPage.open(INDEX_HTML_URL);

        //2 assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //3 log in using certain userID-password
        indexPage.login(PETER);

        //4 assert that username is displayed and has a proper value
        indexPage.checkUsername(PETER);

        //5 assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //6 assert that there are 4 items on the header section, they are displayed and they have proper names
        indexPage.checkHeaderSection(HeaderSection.values());

        //7 assert that there are 4 images on the Index page and they are displayed
        indexPage.checkBenefitImages();

        //8 assert that there is text under of each icon on the Index page and each text is proper
        indexPage.checkBenefitTexts(BenefitTexts.values());

        //9 assert text of the main header
        indexPage.checkMainHeaderTexts(TEXT_HEADER, TEXT_CONTENT);

        //10 assert that there is the iframe in the main page
        indexPage.checkIFrame();

        //11 switch to the iframe and check that there is EPAM logo in the left top corner of iframe, then switch back
        indexPage.checkEpamLogoIFrame();

        //12 assert a text of the sub header
        indexPage.checkSubHeaderText(JDI_GITHUB);

        //13 assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkJdiGithub(JDI_GITHUB_LINK);

        //14 assert that there is Left Section
        indexPage.checkLeftSection();

        //15 assert that there is Footer
        indexPage.checkFooter();
    }
}