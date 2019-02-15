package hw4.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Elements;
import hw4.enums.Colors;
import hw4.enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.enums.Colors.COLOR;
import static hw4.enums.Metals.METAL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> elementsCheckbox;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> metals;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdownColors;

    @FindBy(css = "[class=uui-button]")
    private List<SelenideElement> buttons;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> listLog;

    @FindBy(css = ".uui-form-element option")
    private List<SelenideElement> colors;


    @Step
    public void checkElements() {
        assertEquals(elementsCheckbox.size(), 4);
        elementsCheckbox.forEach(list -> list.should(Condition.visible));
        assertEquals(metals.size(), 4);
        metals.forEach(list -> list.should(Condition.visible));
        assertEquals(colors.size(), 4);
        colors.forEach(list -> list.should(Condition.visible));
        assertEquals(buttons.size(), 2);
        buttons.forEach(list -> list.should(Condition.visible));
    }

    @Step
    public void checkRightSection() {
        rightSection.should(Condition.visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.should(Condition.visible);
    }

    @Step
    public void selectElements(Elements... values) {
        for (SelenideElement element : elementsCheckbox) {
            for (Elements value : values) {
                if (element.getText().toUpperCase().contains(value.toString())) {
                    element.click();
                }
            }
        }
    }

    @Step
    public void selectMetals(Metals... values) {
        for (SelenideElement metal : metals) {
            for (Metals value : values) {
                if (metal.getText().toUpperCase().contains(value.toString())) {
                    metal.click();
                }
            }
        }
    }

    @Step
    public void selectColors(Colors... values) {
        dropdownColors.click();
        for (SelenideElement color : colors) {
            for (Colors value : values) {
                if (color.getText().toUpperCase().contains(value.toString())) {
                    color.click();
                }
            }
        }
    }

    @Step
    public void checkLog(boolean status, String... values) {
        StringBuffer actualValue = new StringBuffer();
        for (String value : values) {
            actualValue.setLength(0);
            for (int i = 0; i < value.length(); i++) {
                if (listLog.get(i).getText().toUpperCase().contains(value) && listLog.get(i).getText()
                        .contains(String.valueOf(status))) {
                    actualValue.append(value);
                    break;
                } else if (listLog.get(i).getText().toLowerCase().contains(METAL.value)
                        || listLog.get(i).getText().toLowerCase().contains(COLOR.value)) {
                    actualValue.append(value);
                    break;
                }
            }
            assertEquals(value, actualValue.toString());
        }
    }

}