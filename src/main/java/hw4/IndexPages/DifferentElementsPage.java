package hw4.IndexPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Buttons;
import hw4.enums.Checkboxes;
import hw4.enums.Colors;
import hw4.enums.Radiobuttons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkBox;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radioButton;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdownColors;

    @FindBy(css = "[class=uui-button]")
    private List<SelenideElement> button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> listLog;

    @FindBy(css = ".uui-form-element option")
    private List<SelenideElement> colors;

    public void checkDifferentElementsPageElements(Checkboxes[] checkboxes, Radiobuttons[] radiobuttons,
                                                   Colors[] dropdown, Buttons[] buttons) {
        assertEquals(checkBox.size(), checkboxes.length);
        checkBox.forEach(list -> list.should(Condition.visible));
        assertEquals(radioButton.size(), radiobuttons.length);
        radioButton.forEach(list -> list.should(Condition.visible));
        assertEquals(colors.size(), dropdown.length);
        colors.forEach(list -> list.should(Condition.visible));
        assertEquals(button.size(), buttons.length);
        button.forEach(list -> list.should(Condition.visible));
    }

    public void checkDifferentElementsPageRightSection() {
        rightSection.should(Condition.visible);
    }

    public void checkDifferentElementsPageLeftSection() {
        leftSection.should(Condition.visible);
    }

    public void selectCheckboxes(Checkboxes value1, Checkboxes value2) {
        for (int i = 0; i < checkBox.size(); i++) {
            if (checkBox.get(i).getText().trim().toUpperCase().equals(value1.toString())) {
                checkBox.get(i).click();
            }
            if (checkBox.get(i).getText().trim().toUpperCase().equals(value2.toString())) {
                checkBox.get(i).click();
            }
        }
    }

    public void checkLogForCheckboxes(Checkboxes value1, Checkboxes value2) {
        listLog.get(0).shouldHave(Condition.text(value2.toString()));
        listLog.get(1).shouldHave(Condition.text(value1.toString()));
    }

    public void selectRadiobuttons(Radiobuttons value) {
        for (int i = 0; i < radioButton.size(); i++) {
            if (radioButton.get(i).getText().toUpperCase().equals(value.toString())) {
                radioButton.get(i).click();
            }
        }
    }

    public void checkLogForRadiobuttons(Radiobuttons value) {
        listLog.get(0).shouldHave(Condition.text(value.toString()));
    }

    public void selectDropdownColors(Colors value) {
        dropdownColors.click();
        for (int i = 0; i < colors.size(); i++) {
            if (colors.get(i).getText().toUpperCase().equals(value.toString())) {
                colors.get(i).click();
            }
        }
    }

    public void checkLogForColors(Colors value) {
        listLog.get(0).shouldHave(Condition.text(value.toString()));
    }
}