package hw6.ex2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import hw4.enums.MenuSections;
import hw4.pageObjects.SelenideIndexPage;
import hw6.UserTablePage;
import hw6.enums.UserTableNames;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private SelenideIndexPage indexPage = page(SelenideIndexPage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @When("^I click on Service button in Header$")
    public void clickOnHeaderSubcategories() {
        indexPage.openHeaderSection();
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void openPage(MenuSections page) {
        indexPage.openPage(page);
    }

    @When("^I select 'vip' checkbox for '([^\"]*)'$")
    public void selectNameCheckbox(UserTableNames name) {
        userTablePage.selectCheckbox(name);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void openDropdownColumnType(UserTableNames name) {
        userTablePage.openDropdownByUsername(name);
    }
}
