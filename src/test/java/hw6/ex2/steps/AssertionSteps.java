package hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw4.enums.MenuSections;
import hw6.UserTablePage;
import hw6.SuperHero;
import hw6.enums.UserTableDropList;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {

    private UserTablePage userTablePage = page(UserTablePage.class);

    @Then("'([^\"]*)' page is opened")
    public void checkTitle(MenuSections title) {
        userTablePage.checkTitle(title);
    }

    @And("^6 NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkDropdownsAreDisplayed() {
        userTablePage.checkDropdowns();
    }

    @And("6 User names are displayed on Users Table on User Table Page$")
    public void checkUserNamesAreDisplayed() {
        userTablePage.checkUsernames();
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void checkDescriptionImagesAreDisplayed() {
        userTablePage.checkDescriptionImages();
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayed() {
        userTablePage.checkDescriptionImagesTexts();
    }

    // TODO I assume that it will be better with List<SuperHero>, for the example
    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<SuperHero> values) {
        userTablePage.checkUserTableValues(values);
    }

    @Then("^1 log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(String log) {
        userTablePage.checklog(log);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<UserTableDropList> values) {
        userTablePage.checkDroplistValues(values);
    }
}
