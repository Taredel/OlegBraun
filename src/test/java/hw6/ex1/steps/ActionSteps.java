package hw6.ex1.steps;

import cucumber.api.java.en.When;
import hw3.enums.User;
import hw4.enums.*;
import hw4.pageObjects.DifferentElementsPage;
import hw4.pageObjects.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private SelenideIndexPage indexPage = page(SelenideIndexPage.class);
    private DifferentElementsPage difPage = page(DifferentElementsPage.class);

    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(User user) {
        indexPage.login(user);
    }

    @When("^I click on Service subcategory in the Header$")
    public void clickOnHeaderSubcategories() {
        indexPage.openHeaderSection();
    }

    @When("^I click on Service subcategory in the LeftSection$")
    public void clickOnLeftSection() {
        indexPage.openLeftSection();
    }

    @When("^I open Service -> '([^\"]*)' page$")
    public void openPage(MenuSections page) {
        indexPage.openHeaderSection();
        indexPage.openPage(page);
    }

    @When("^I select checkboxes '([^\"]*)' and '([^\"]*)'$")
    public void selectCheckboxes(Elements value1, Elements value2) {
        difPage.selectElements(value1, value2);
    }

    @When("^I select radiobutton '([^\"]*)'$")
    public void selectRadiobuttons(Metals value) {
        difPage.selectMetals(value);
    }

    @When("^I select '([^\"]*)' color$")
    public void selectColor(Colors value) {
        difPage.selectColors(value);
    }

    @When("^I unselect checkboxes '([^\"]*)' and '([^\"]*)'$")
    public void unselectCheckboxes(Elements value1, Elements value2) {
        difPage.selectElements(value1, value2);
    }
}
