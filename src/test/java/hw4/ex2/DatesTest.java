package hw4.ex2;

import hw4.IndexPages.DatesPage;
import hw4.IndexPages.SelenideIndexPage;
import hw4.SelenideBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static hw3.enums.HomePageData.INDEX_HTML_URL;
import static hw3.enums.Users.PETER;
import static hw4.enums.MenuSections.DATES;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

@Listeners(AllureAttachmentListener.class)
@Feature("Selenide Test Suite")
@Story("DatesPage Page Test")
public class DatesTest extends SelenideBase {

    private SelenideIndexPage indexPage;
    private DatesPage dates;

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_HTML_URL.value);
        indexPage = page(SelenideIndexPage.class);
        dates = page(DatesPage.class);
    }

    @Test
    public void datesPageTest() {

        //1 assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //2 log in using certain userID-password
        indexPage.login(PETER);

        //3 assert that username is displayed and has a proper value
        indexPage.checkUsername(PETER);

        //4 open Service -> DatesPage page
        indexPage.openPage(DATES);

        //5 set left slider in the most left position and right slider in the most right position
        dates.moveSliders(0, 100);

        //6 check that both sliders were moved in proper places and there are log for each of them
        dates.checkSlidersPositions(0, 100);

        //7 set left slider in the most left position and right slider in the most left position
        dates.moveSliders(0, 0);

        //8 check that both sliders were moved in proper places and there are log for each of them
        dates.checkSlidersPositions(0, 0);

        //9 set left slider in the most right position and right slider in the most right position
        dates.moveSliders(100, 100);

        //10 check that both sliders were moved in proper places and there are log for each of them
        dates.checkSlidersPositions(100, 100);

        //11 move left sliders to 30 and right slider to 70
        dates.moveSliders(30, 70);

        //12 check that both sliders were moved in proper places and there are log for each of them
        dates.checkSlidersPositions(30, 70);
    }
}
