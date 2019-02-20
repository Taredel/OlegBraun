package hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw3.enums.BenefitTexts;
import hw3.enums.HomePageData;
import hw3.enums.User;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.MenuSections;
import hw4.enums.Metals;
import hw4.pageObjects.DifferentElementsPage;
import hw4.pageObjects.SelenideIndexPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static hw3.enums.HomePageData.TEXT_CONTENT;
import static hw3.enums.HomePageData.TEXT_HEADER;

public class AssertionSteps {

    private SelenideIndexPage indexPage = page(SelenideIndexPage.class);
    private DifferentElementsPage difPage = page(DifferentElementsPage.class);

    @Then("^Title should be '([^\"]*)'$")
    public void checkTitle(HomePageData title) {
        indexPage.checkTitle(title);
    }

    @Then("^User name should be '([^\"]*)'$")
    public void checkUsername(User user) {
        indexPage.checkUsername(user);
    }

    @And("^Home page should have 4 pictures, 4 texts under them and 2 text above$")
    public void homePageShouldHavePicturesTextsUnderThemAndTextAbove() {
        indexPage.checkBenefitImages();
        indexPage.checkBenefitTexts(BenefitTexts.values());
        indexPage.checkMainHeaderTexts(TEXT_HEADER, TEXT_CONTENT);
    }

    @Then("^Dropdown section should contains all options$")
    public void dropdownSectionContainsAllOptions(List<MenuSections> list) {
        MenuSections[] arr = list.toArray(new MenuSections[0]);
        indexPage.checkDropDownSection(arr);
    }

    @Then("^Left Sections should contains all options$")
    public void leftSectionsContainsAllOptions(List<MenuSections> list) {
        MenuSections[] arr = list.toArray(new MenuSections[0]);
        indexPage.checkLeftSection(arr);
    }

    @Then("^Different Elements Page contains all needed elements$")
    public void differentElementsPageCheckElements() {
        difPage.checkElements();
    }

    @And("^Different Elements Page contains Right Section$")
    public void differentElementsPageCheckRightSection() {
        difPage.checkRightSection();
    }

    @And("^Different Elements Page contains Left Section$")
    public void differentElementsPageCheckLeftSection() {
        difPage.checkLeftSection();
    }

    @Then("^For each checkbox there is a log row corresponding their status '([^\"]*)'$")
    public void checkCheckboxLogWhenTrue(boolean status, List<String> values) {
        String[] arr = values.toArray(new String[0]);
        difPage.checkLog(status, arr);
    }

    @Then("^There is a log for selected radiobutton '([^\"]*)'$")
    public void checkMetalLogWhenTrue(String value) {
        difPage.checkLog(true, value);
    }

    @Then("^There is a log for selected color '([^\"]*)'$")
    public void checkColorLogWhenTrue(String value) {
        difPage.checkLog(true, value);
    }
}
