package hw4.ex1;

import com.codeborne.selenide.Selenide;
import hw3.enums.Users;
import hw4.SelenideBase;
import hw4.enums.SelenideIndexPageData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * This class tests web page with URL "https://epam.github.io/JDI/" and one specific page using Selenide
 * and PageObject pattern.
 *
 * @author Oleg Braun
 * @version 1.0 02 Feb 2019
 */

public class SelenideDifferentElementsPageTest extends SelenideBase {

    private SelenideDEPIndexPage indexPage;

    @BeforeMethod
    public void beforeMethod() {
        Selenide.open(SelenideIndexPageData.HOME_PAGE_URL.value);
        indexPage = page(SelenideDEPIndexPage.class);
    }

    @Test
    public void differentElementsPageTest() {
        //1 assert Browser title
        indexPage.checkTitle(SelenideIndexPageData.HOME_PAGE_TITLE);

        //2 log in using certain userID-password
        indexPage.login(Users.PETER);

        //3 assert that username is displayed and has a proper value
        indexPage.checkUsername(Users.PETER);

        //4 check that "Service" subcategory in the header contains options and they are proper
        indexPage.checkDropDownSection();

        //5 check that "Service" subcategory in the left section contains options and they are proper
        indexPage.checkDifferentElementsPageLeftSection();

        //6 assert that there are 4 items on the header section, they are displayed and they have proper names
        indexPage.checkHeaderSection();

        //7 open Service -> Different Elements Page
        indexPage.openDifferentElementsPage();

        //8 check that Different Elements Page contains all elements it should have
        indexPage.checkDifferentElementsPageElements();

        //9 check that there is right section in Different Elements Page
        indexPage.checkDifferentElementsPageRightSection();

        //10 check that there is left section in Different Elements Page
        indexPage.checkDifferentElementsPageLeftSection();

        //11 select checkboxes
        indexPage.selectCheckboxes();

        //12 check that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.checkLogForCheckboxes(SelenideIndexPageData.checkBox);

        //13 select radiobuttons
        indexPage.selectRadiobuttons();

        //14 check that for each radiobutton there is a individual log row and value is corresponded to the status of radiobutton. 
        indexPage.checkLogForRadiobuttons(SelenideIndexPageData.radioButton);

        //15 select that colors in a dropdown are proper
        indexPage.selectDropdownColors();

        //16 check that for dropdown there is a log row and value is corresponded to the selected value.
        indexPage.checkLogForColors(SelenideIndexPageData.colors);

        //17 unselect checkboxes and check that they are unselected
        indexPage.unselectCheckboxes();

        //18 check that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        indexPage.checkLogForUnselectedCheckboxes(SelenideIndexPageData.checkBox);
    }
}
