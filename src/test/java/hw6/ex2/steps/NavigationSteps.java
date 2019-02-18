package hw6.ex2.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import hw4.pageObjects.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static hw3.enums.HomePageData.INDEX_HTML_URL;

public class NavigationSteps {

    @Given("^I am on Home Page$")
    public void openPage() {
        open(INDEX_HTML_URL.value);
    }
}

