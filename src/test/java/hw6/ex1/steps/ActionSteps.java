package hw6.ex1.steps;

import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.MenuSections;
import hw4.enums.Metals;
import cucumber.api.java.en.When;
import hw3.enums.User;
import hw4.pageObjects.DifferentElementsPage;
import hw4.pageObjects.SelenideIndexPage;

import java.util.List;

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

    @When("^I select checkboxes")
    public void selectCheckboxes(List<Elements> values) {
        Elements[] arr = values.toArray(new Elements[0]);
        difPage.selectElements(arr);
    }

    @When("^I select radiobutton '([^\"]*)'")
    public void selectRadiobuttons(Metals value) {
        difPage.selectMetals(value);
    }

    @When("^I select colors '([^\"]*)'$")
    public void selectColor(Colors value) {
        difPage.selectColors(value);
    }

    @When("^I unselect checkboxes$")
    public void unselectCheckboxes(List<Elements> values) {
        Elements[] arr = values.toArray(new Elements[0]);
        difPage.selectElements(arr);
    }
}
