package hw6.ex1.steps;

import cucumber.api.java.en.When;
import hw3.enums.User;
import hw4.enums.*;
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

    @When("^I select radiobutton")
    public void selectRadiobuttons(List<Metals> values) {
        Metals[] arr = values.toArray(new Metals[0]);
        difPage.selectMetals(arr);
    }

    @When("^I select colors$")
    public void selectColor(List<Colors> values) {
        Colors[] arr = values.toArray(new Colors[0]);
        difPage.selectColors(arr);
    }

    @When("^I unselect checkboxes$")
    public void unselectCheckboxes(List<Elements> values) {
        Elements[] arr = values.toArray(new Elements[0]);
        difPage.selectElements(arr);
    }
}
