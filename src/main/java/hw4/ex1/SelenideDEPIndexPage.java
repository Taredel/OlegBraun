package hw4.ex1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import hw3.enums.Users;
import hw4.enums.SelenideIndexPageData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static hw4.enums.SelenideIndexPageData.*;
import static org.testng.Assert.assertEquals;

public class SelenideDEPIndexPage {

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

    @FindBy(css = ".dropdown-menu a[href*=different]")
    private SelenideElement differentElementsPage;

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> dEPCheckBox;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> dEPRadioButton;

    @FindBy(css = ".colors")
    private SelenideElement dEPdropdown;

    @FindBy(css = "button[class=uui-button]")
    private SelenideElement dEPbutton;

    @FindBy(css = "input[class=uui-button]")
    private SelenideElement dEPdefaultButton;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement dEPrightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement dEPleftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> dEPListLog;

    @FindBy(css = ".uui-form-element option")
    private List<SelenideElement> dEPcolors;

    public void checkTitle(SelenideIndexPageData homePageTitle) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle(), homePageTitle.value);
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUsername(Users user) {
        usernameField.should(Condition.visible);
        usernameField.should(text(user.getUsername()));
    }

    public void checkDropDownSection() {
        dropdown.click();
        dropdownMenu.forEach(list -> list.should(Condition.visible));
        for (int i = 0; i < dropdownMenu.size(); i++) {
            dropdownMenu.get(i).should(text(getDropdownMenuElements().get(i)));
        }
    }

    public void checkHeaderSection() {
        leftSection.click();
        leftSectionMenu.forEach(list -> list.should(Condition.visible));
        for (int i = 0; i < leftSectionMenu.size(); i++) {
            leftSectionMenu.get(i).should(text(getLeftSectionMenuElements().get(i)));
        }
    }

    public void openDifferentElementsPage() {
        dropdown.click();
        differentElementsPage.click();
    }

    public void checkDifferentElementsPageElements() {
        dEPCheckBox.forEach(list -> list.should(Condition.visible));
        assertEquals(dEPCheckBox.size(), 4);
        dEPRadioButton.forEach(list -> list.should(Condition.visible));
        assertEquals(dEPRadioButton.size(), 4);
        dEPdropdown.should(Condition.visible);
        dEPbutton.should(Condition.visible);
        dEPdefaultButton.should(Condition.visible);
    }

    public void checkDifferentElementsPageRightSection() {
        dEPrightSection.should(Condition.visible);
    }

    public void checkDifferentElementsPageLeftSection() {
        dEPleftSection.should(Condition.visible);
    }

    public void selectCheckboxes() {
        for (int i = 0; i < dEPCheckBox.size(); i++) {
            dEPCheckBox.get(i).click();
            sleep(1000); // TODO This is really bad practice
        }
    }

    public void checkLogForCheckboxes(List<String> checkBox) {
        initCheckBox();
        for (int i = 0; i < checkBox.size(); i++) {
            dEPListLog.get(i).shouldHave(text(checkBox.get(checkBox.size() - i - 1)));
        }
    }

    public void selectRadiobuttons() {
        for (int i = 0; i < dEPRadioButton.size(); i++) {
            dEPRadioButton.get(i).click();
            sleep(1000);
        }
    }

    public void checkLogForRadiobuttons(List<String> radioButton) {
        initRadioButtons();
        for (int i = 0; i < radioButton.size(); i++) {
            dEPListLog.get(i).shouldHave(text(radioButton.get(radioButton.size() - i - 1)));
        }
    }

    public void selectDropdownColors() {
        dEPdropdown.click();
        for (int i = dEPcolors.size() - 1; i >= 0; i--) {
            dEPcolors.get(i).click();
            sleep(1000);
        }
    }

    public void checkLogForColors(List<String> colors) {
        initColors();
        for (int i = 0; i < colors.size(); i++) {
            dEPListLog.get(i).shouldHave(text(colors.get(i)));
        }
    }

    public void unselectCheckboxes() {
        for (int i = 0; i < dEPCheckBox.size(); i++) {
            sleep(1000);
            dEPCheckBox.get(i).click();
        }
    }

    public void checkLogForUnselectedCheckboxes(List<String> checkBox) {
        for (int i = 0; i < checkBox.size(); i++) {
            dEPListLog.get(i).shouldHave(text(checkBox.get(checkBox.size() - i - 1)));
            dEPListLog.get(i).shouldHave(text("false"));
        }
    }
}