package hw4.IndexPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import hw3.enums.HomePageData;
import hw3.enums.Users;
import hw4.enums.MenuSections;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.*;

public class SelenideIndexPage {

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement usernameField;

    @FindBy(css = "[class='dropdown']")
    private SelenideElement dropdown;

    @FindBy(css = ".dropdown-menu li")
    private List<SelenideElement> dropdownMenu;

    @FindBy(css = "a[ui=label]")
    private SelenideElement leftSection;

    @FindBy(css = "a[ui=label] + ul li")
    private List<SelenideElement> leftSectionMenu;

    @Step
    public void checkTitle(HomePageData title) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle(), title.toString());
    }

    @Step
    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    @Step
    public void checkUsername(Users user) {
        assertTrue(usernameField.isDisplayed());
        assertEquals(usernameField.getText(), user.getUsername());
    }

    @Step
    public void checkDropDownSection(MenuSections[] values) {
        dropdown.click();
        List<String> actual = dropdownMenu
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        for (MenuSections value : values) {
            assertTrue(actual.contains(value.toString()));
        }
    }

    @Step
    public void checkLeftSection(MenuSections[] values) {
        leftSection.click();
        List<String> actual = leftSectionMenu
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        for (MenuSections value : values) {
            assertTrue(actual.toString().toUpperCase().contains(value.toString()));
        }
    }

    @Step
    public void openPage(MenuSections menuSection) {
        dropdown.click();
        $(".dropdown-menu a[href*=" + menuSection.toString().substring(0, 4).toLowerCase() + "]").click();
    }
}