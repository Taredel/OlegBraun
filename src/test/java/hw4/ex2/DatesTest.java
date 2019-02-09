package hw4.ex2;

import hw3.enums.Users;
import hw4.IndexPages.Dates;
import hw4.IndexPages.SelenideIndexPage;
import hw4.SelenideBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static hw3.enums.HomePageData.INDEX_HTML_URL;
import static hw4.enums.MenuSections.MENU_SECTION_2;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

public class DatesTest extends SelenideBase {

    // TODO This is not an dates
    private SelenideIndexPage indexPage;
    private Dates dates;

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_HTML_URL.value);
        indexPage = page(SelenideIndexPage.class);
        dates = page(Dates.class);
    }

    @Test
    public void datesPageTest() {

        //1 assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //2 log in using certain userID-password
        indexPage.login(Users.PETER);

        //3 assert that username is displayed and has a proper value
        indexPage.checkUsername(Users.PETER);

        //4 open Service -> Dates page
        indexPage.openPage(MENU_SECTION_2.value);

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
