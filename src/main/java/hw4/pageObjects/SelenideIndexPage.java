package hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import hw3.enums.BenefitTexts;
import hw3.enums.HomePageData;
import hw3.enums.User;
import hw4.enums.MenuSections;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
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

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> benefitTexts;

    @FindBy(css = "[name='main-title']")
    private SelenideElement headline;

    @FindBy(css = "[name='jdi-text']")
    private SelenideElement textBelowHeadline;

    @FindBy(css = "[class='dropdown']")
    private SelenideElement dropdown;

    @FindBy(css = ".dropdown-menu li")
    private List<SelenideElement> dropdownMenu;

    @FindBy(css = "a[ui=label]")
    private SelenideElement leftSection;

    @FindBy(css = "a[ui=label] + ul li")
    private List<SelenideElement> leftSectionMenu;

    public SelenideIndexPage() {
        page(this);
    }

    @Step
    public void checkTitle(HomePageData title) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle(), title.toString());
    }

    @Step("Log in with user '{user.login}' and password '{user.password}'")
    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    @Step
    public void checkUsername(User user) {
        assertTrue(usernameField.isDisplayed());
        assertEquals(usernameField.getText(), user.getUsername());
    }

    @Step
    public void checkBenefitImages() {
        assertEquals(benefitImages.size(), 4);
        for (SelenideElement image : benefitImages) {
            image.shouldBe(Condition.visible);
        }
    }

    @Step
    public void checkBenefitTexts(BenefitTexts[] values) {
        assertEquals(benefitTexts.size(), 4);
        List<String> actual = benefitTexts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (BenefitTexts value : values) {
            assertTrue(actual.contains(value.toString()));
        }
    }

    @Step
    public void checkMainHeaderTexts(HomePageData textHeader, HomePageData textContent) {
        headline.shouldHave(Condition.text(textHeader.toString()));
        textBelowHeadline.shouldHave(Condition.text(textContent.toString()));
    }

    @Step
    public void checkDropDownSection(MenuSections[] values) {
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
        $(".dropdown-menu a[href*=" + menuSection.toString().substring(0, 4).toLowerCase() + "]").click();
    }

    public void openHeaderSection() {
        dropdown.click();
    }

    public void openLeftSection() {
        leftSection.click();
    }

    public SelenideElement getUsername() {
        return usernameField;
    }
}