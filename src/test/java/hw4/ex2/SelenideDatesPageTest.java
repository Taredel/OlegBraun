package hw4.ex2;

import hw3.enums.Users;
import hw4.SelenideBase;
import hw4.enums.SelenideIndexPageData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

public class SelenideDatesPageTest extends SelenideBase {

    private SelenideDatesIndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        open(SelenideIndexPageData.HOME_PAGE_URL.value);
        indexPage = page(SelenideDatesIndexPage.class);
    }

    @Test
    public void datesPageTest() {
        //1 assert Browser title
        indexPage.checkTitle(SelenideIndexPageData.HOME_PAGE_TITLE);

        //2 log in using certain userID-password
        indexPage.login(Users.PETER);

        //3 assert that username is displayed and has a proper value
        indexPage.checkUsername(Users.PETER);

        //4 open Service -> Dates page
        indexPage.openDatesPage();

        //5 set left slider in the most left position and right slider in the most right position
        indexPage.moveSlidersBoundryPosition();

        //6 check that both sliders were moved in proper places and there are log for each of them
        indexPage.checkSlidersPositionsWhenLeftSliderGoesFirst(0, 100);

        //7 set left slider in the most left position and right slider in the most left position
        indexPage.moveSlidersToLeftBorder();

        //8 check that both sliders were moved in proper places and there are log for each of them
        indexPage.checkSlidersPositionsWhenLeftSliderGoesFirst(0, 0);

        //9 set left slider in the most right position and right slider in the most right position
        indexPage.moveSlidersToRightBorder();

        //10 check that both sliders were moved in proper places and there are log for each of them
        indexPage.checkSlidersPositionsWhenRightSliderGoesFirst(100, 100);

        //11 move left sliders to 30 and right slider to 70
        indexPage.moveSlidersCertainPositions();

        //12 check that both sliders were moved in proper places and there are log for each of them
        indexPage.checkSlidersPositionsWhenLeftSliderGoesFirst(30, 70);
    }
}
