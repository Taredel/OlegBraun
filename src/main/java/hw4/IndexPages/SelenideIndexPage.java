package hw4.IndexPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import hw3.enums.HomePageData;
import hw3.enums.Users;
import hw4.enums.MenuSections;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public void checkTitle(HomePageData title) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle(), title.toString());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUsername(Users user) {
        assertTrue(usernameField.isDisplayed());
        assertEquals(usernameField.getText(), user.getUsername());
    }

    public void checkDropDownSection(MenuSections[] value) {
        dropdown.click();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < dropdownMenu.size(); j++) {
                if (dropdownMenu.get(j).toString().contains(value[i].toString())) {
                    dropdownMenu.get(j).should(Condition.visible);
                    dropdownMenu.get(j).shouldHave(text(value[i].toString()));
                }
            }
        }
    }

    public void checkLeftSection(MenuSections[] value) {
        leftSection.click();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < leftSectionMenu.size(); j++) {
                if (leftSectionMenu.get(j).toString().contains(value[i].toString())) {
                    leftSectionMenu.get(j).should(Condition.visible);
                    leftSectionMenu.get(j).shouldHave(text(value[i].toString()));
                }
            }
        }
    }

    public void openPage(String menuSection) {
        dropdown.click();
        $(".dropdown-menu a[href*=" + menuSection.substring(0, 4).toLowerCase() + "]").click();
    }
}