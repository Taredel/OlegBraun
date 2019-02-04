package hw4.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import hw3.enums.Users;
import hw4.enums.SelenideIndexPageData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.sleep;
import static hw4.enums.SelenideIndexPageData.LEFT_SLIDER;
import static hw4.enums.SelenideIndexPageData.RIGHT_SLIDER;
import static org.testng.Assert.assertEquals;

public class SelenideDatesIndexPage {

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

    @FindBy(css = ".dropdown-menu a[href*=dates]")
    private SelenideElement datesPage;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> nodes;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> log;

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

    public void openDatesPage() {
        dropdown.click();
        datesPage.click();
    }

    public void moveSlidersBoundryPosition() {
        sleep(1000);
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        sleep(1000);
        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();
        sleep(1000);
    }

    public void checkSlidersPositionsWhenLeftSliderGoesFirst(int leftSliderValue, int rightSliderValue) {
        log.get(1).shouldHave(text(LEFT_SLIDER.value));
        log.get(1).shouldHave(text(String.valueOf(leftSliderValue)));
        log.get(0).shouldHave(text(RIGHT_SLIDER.value));
        log.get(0).shouldHave(text(String.valueOf(rightSliderValue)));
    }

    public void moveSlidersToLeftBorder() {
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        sleep(1000);
        actions().dragAndDropBy(nodes.get(1), -1000, 0).build().perform();
        sleep(1000);
    }

    public void moveSlidersToRightBorder() {
        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();
        sleep(1000);
        actions().dragAndDropBy(nodes.get(0), 1000, 0).build().perform();
        sleep(1000);
    }

    public void checkSlidersPositionsWhenRightSliderGoesFirst(int leftSliderValue, int rightSliderValue) {
        log.get(0).shouldHave(text(LEFT_SLIDER.value));
        log.get(0).shouldHave(text(String.valueOf(leftSliderValue)));
        log.get(1).shouldHave(text(RIGHT_SLIDER.value));
        log.get(1).shouldHave(text(String.valueOf(rightSliderValue)));
    }

    public void moveSlidersCertainPositions() {
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        double sliderBarLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
        double step = sliderBarLength / 100;
        actions().dragAndDropBy(nodes.get(0), (int) (30 * step - 0.5 * step), 0).build().perform();
        sleep(1000);
        actions().dragAndDropBy(nodes.get(1), (int) (-(30 * step + step)), 0).build().perform();
        sleep(1000);
    }
}