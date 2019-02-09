package hw4.ex1;


import hw3.enums.Users;
import hw4.IndexPages.DifferentElementsPage;
import hw4.IndexPages.SelenideIndexPage;
import hw4.SelenideBase;
import hw4.enums.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static hw3.enums.HomePageData.INDEX_HTML_URL;
import static hw4.enums.MenuSections.MENU_SECTION_6;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

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
        selenideIndexPage.login(Users.PETER);

        //3 assert that username is displayed and has a proper value
        selenideIndexPage.checkUsername(Users.PETER);

        //4 check that "Service" subcategory in the header contains options and they are proper
        selenideIndexPage.checkDropDownSection(MenuSections.values());

        //5 check that "Service" subcategory in the left section contains options and they are proper
        selenideIndexPage.checkLeftSection(MenuSections.values());

        //6 open Service -> Different Elements Page
        // TODO This method should be parametrised
        selenideIndexPage.openPage(MENU_SECTION_6.value);

        //8 check that Different Elements Page contains all elements it should have
        // TODO All of this methods should not be in selenideIndexPage !!
        differentElementsPage.checkDifferentElementsPageElements(Checkboxes.values(), Radiobuttons.values(),
                Colors.values(), Buttons.values());

        //9 check that there is right section in Different Elements Page
        differentElementsPage.checkDifferentElementsPageRightSection();

        //10 check that there is left section in Different Elements Page
        differentElementsPage.checkDifferentElementsPageLeftSection();

        //11 select checkboxes
        // TODO Take a look on HW task, Data column.
        // TODO This method should be parametrised.
        // TODO Same story with methods below, take a look on HW task carefully
        differentElementsPage.selectCheckboxes(Checkboxes.CHECKBOX_1, Checkboxes.CHECKBOX_3);

        //12 check that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogForCheckboxes(Checkboxes.CHECKBOX_1, Checkboxes.CHECKBOX_3);

        //13 select radiobuttons
        differentElementsPage.selectRadiobuttons(Radiobuttons.RADIOBUTTON_4);

        //14 check that for each radiobutton there is a individual log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLogForRadiobuttons(Radiobuttons.RADIOBUTTON_4);

        //15 select that colors in a dropdown are proper
        differentElementsPage.selectDropdownColors(Colors.COLOR_4);

        //16 check that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkLogForColors(Colors.COLOR_4);

        //17 unselect checkboxes and check that they are unselected
        differentElementsPage.selectCheckboxes(Checkboxes.CHECKBOX_1, Checkboxes.CHECKBOX_3);

        //18 check that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPage.checkLogForCheckboxes(Checkboxes.CHECKBOX_1, Checkboxes.CHECKBOX_3);
    }
}
