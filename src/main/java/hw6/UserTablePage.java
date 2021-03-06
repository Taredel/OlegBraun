package hw6;

import hw4.enums.MenuSections;
import hw6.enums.UserTableNames;
import com.codeborne.selenide.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class UserTablePage {

    @FindBy(css = "select")
    private List<SelenideElement> dropdowns;

    @FindBy(css = "td a")
    private List<SelenideElement> usernames;

    @FindBy(css = "td img")
    private List<SelenideElement> desctiptionImages;

    @FindBy(css = ".user-descr span")
    private List<SelenideElement> desctiptionImagesTexts;

    @FindBy(css = "td:nth-child(1)")
    private List<SelenideElement> numbers;

    @FindBy(css = "input[id]")
    private List<SelenideElement> vipCheckboxes;

    @FindBy(css = ".logs li")
    private List<SelenideElement> log;

    public UserTablePage() {
        page(this);
    }

    public void checkTitle(MenuSections title) {
        assertEquals(WebDriverRunner.getWebDriver().getTitle().toUpperCase(), title.toString());
    }

    public void checkDropdowns() {
        assertEquals(dropdowns.size(), 6);
        dropdowns.forEach(list -> list.shouldBe(Condition.visible));
    }

    public void checkUsernames() {
        assertEquals(usernames.size(), 6);
        usernames.forEach(list -> list.shouldBe(Condition.visible));
    }

    public void checkDescriptionImages() {
        assertEquals(desctiptionImages.size(), 6);
        desctiptionImages.forEach(list -> list.shouldBe(Condition.visible));
    }

    public void checkDescriptionImagesTexts() {
        assertEquals(desctiptionImagesTexts.size(), 6);
        desctiptionImagesTexts.forEach(list -> list.shouldBe(Condition.visible));
    }

    public void checkUserTableValues(List<SuperHero> values) {
        for (int i = 0; i < values.size(); i++) {
            numbers.get(i).shouldBe(text(values.get(i).getNumber()));
            usernames.get(i).shouldBe(text(values.get(i).getUser()));
            desctiptionImagesTexts.get(i).shouldBe(text(values.get(i).getDescription()));
        }
    }

    public void selectCheckbox(UserTableNames name) {
        for (SelenideElement vip : vipCheckboxes) {
            if (name.value.toLowerCase().contains(vip.getAttribute("id"))) {
                vip.click();
            }
        }
    }

    public void checklog(String logValue) {
        log.get(0).shouldHave(text(logValue));
    }

    private static String userName;

    public void openDropdownByUsername(UserTableNames name) {
        userName = name.value;
        $(xpath(String.format("//a[text()='%s']/ancestor::tr//select", userName))).click();
    }

    public void checkDroplistValues(List<String> values) {
        $$(xpath(String.format("//a[text()='%s']/ancestor::tr//select/option", userName)))
                .shouldHave(CollectionCondition.texts(values));
    }
}
