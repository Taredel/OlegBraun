package hw4.ex1;


import hw4.IndexPages.DifferentElementsPage;
import hw4.IndexPages.SelenideIndexPage;
import hw4.SelenideBase;
import hw4.enums.*;
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
import static hw4.enums.Colors.YELLOW;
import static hw4.enums.Elements.*;
import static hw4.enums.MenuSections.DIFFERENT_ELEMENTS;
import static hw4.enums.Metals.SELEN;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

@Listeners(AllureAttachmentListener.class)
@Feature("Selenide Test Suite")
@Story("Different Elements Page Test")
public class DifferentElementsTest extends SelenideBase {

    // TODO This is not an SelenideIndexPage, this should be DifferentElementPage !
    private SelenideIndexPage selenideIndexPage;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_HTML_URL.value);
        selenideIndexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1 assert Browser title
        selenideIndexPage.checkTitle(HOME_PAGE_TITLE);

        //2 log in using certain userID-password
        selenideIndexPage.login(PETER);

        //3 assert that username is displayed and has a proper value
        selenideIndexPage.checkUsername(PETER);

        //4 check that "Service" subcategory in the header contains options and they are proper
        selenideIndexPage.checkDropDownSection(MenuSections.values());

        //5 check that "Service" subcategory in the left section contains options and they are proper
        selenideIndexPage.checkLeftSection(MenuSections.values());

        //6 open Service -> Different Elements Page
        // TODO This method should be parametrised
        selenideIndexPage.openPage(DIFFERENT_ELEMENTS);

        //8 check that Different Elements Page contains all elements it should have
        // TODO All of this methods should not be in selenideIndexPage !!
        differentElementsPage.checkElements();

        //9 check that there is right section in Different Elements Page
        differentElementsPage.checkRightSection();

        //10 check that there is left section in Different Elements Page
        differentElementsPage.checkLeftSection();

        //11 select checkboxes containing elements
        // TODO Take a look on HW task, Data column.
        // TODO This method should be parametrised.
        // TODO Same story with methods below, take a look on HW task carefully
        differentElementsPage.selectElements(WATER, WIND);

        //12 check that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLog(true, WATER.value, WIND.value);

        //13 select radiobuttons containing metals
        differentElementsPage.selectMetals(SELEN);

        //14 check that for each radiobutton there is a individual log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLog(true, SELEN.value);

        //15 select colors
        differentElementsPage.selectColors(YELLOW);

        //16 check that for each selected color there is a log row and it value is corresponded to the selected value.
        differentElementsPage.checkLog(true, YELLOW.value);

        //17 unselect element checkboxes
        differentElementsPage.selectElements(WATER, WIND);

        //18 check that for each element checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLog(false, WATER.value, WIND.value);
    }
}
