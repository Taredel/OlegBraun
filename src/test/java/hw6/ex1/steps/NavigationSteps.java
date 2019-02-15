package hw6.ex1.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static hw3.enums.HomePageData.INDEX_HTML_URL;

public class NavigationSteps {

    @Given("^I open EPAM JDI site$")
    public void openPage() {
        open(INDEX_HTML_URL.value);
    }
}
