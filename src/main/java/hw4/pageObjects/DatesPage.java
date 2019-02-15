package hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static hw4.enums.DatesData.LEFT_SLIDER;
import static hw4.enums.DatesData.RIGHT_SLIDER;

public class DatesPage {

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> nodes;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> log;

    private static double step;

    @Step
    public void moveSliders(int left, int right) {
        if (left == 0 && right == 100) {
            actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
            actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();
            double scrollPanelLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
            step = scrollPanelLength / 100;
        } else if (nodes.get(0).getLocation().getX() == nodes.get(1).getLocation().getX() &&
                left > Integer.valueOf(nodes.get(0).getText())) {
            actions().dragAndDropBy(nodes.get(1), (int) (right * step - 0.5 * step), 0).build().perform();
            actions().dragAndDropBy(nodes.get(0), (int) (left * step - 0.5 * step), 0).build().perform();
        } else {
            actions().dragAndDropBy(nodes.get(0), (int) (-((Integer.valueOf(nodes.get(0).getText()) - left) * step + step)),
                    0).build().perform();
            nodes.get(0).click();
            actions().dragAndDropBy(nodes.get(1), (int) (-((Integer.valueOf(nodes.get(1).getText()) - right) * step + step)),
                    0).build().perform();
        }
    }

    @Step
    public void checkSlidersPositions(int leftSliderValue, int rightSliderValue) {
        for (int i = 0; i < 2; i++) {
            if (log.get(i).getText().contains(LEFT_SLIDER.value)) {
                log.get(i).shouldHave(text(LEFT_SLIDER.value));
                log.get(i).shouldHave(text(String.valueOf(leftSliderValue)));
            } else {
                log.get(i).shouldHave(text(RIGHT_SLIDER.value));
                log.get(i).shouldHave(text(String.valueOf(rightSliderValue)));
            }
        }
    }
}