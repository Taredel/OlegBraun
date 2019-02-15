package hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.DataTable;
import hw4.enums.MenuSections;
import hw6.enums.UserTableDropList;
import hw6.enums.UserTableNames;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
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

    public void checkUserTableValues(DataTable dataTable) {
        List<List<String>> values = dataTable.raw();
        for (int j = 0; j < values.get(j).size(); j++) {
            for (int i = 0; i < values.size() - 1; i++) {
                switch (j) {
                    case 0:
                        assertEquals(numbers.get(i).getText(), values.get(i + 1).get(j));
                        break;
                    case 1:
                        assertEquals(usernames.get(i).getText(), values.get(i + 1).get(j));
                        break;
                    case 2:
                        assertEquals(desctiptionImagesTexts.get(i).getText().replaceAll("[\n\r]", " "),
                                values.get(i + 1).get(j));
                        break;
                }
            }
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
        log.get(0).shouldHave(Condition.text(logValue));
    }

    private static String locatorForDroplist;

    public void openDropdownByUsername(UserTableNames name) {
        locatorForDroplist = "//a[text()='" + name.value + "']/ancestor::tr//select";
        $(xpath(locatorForDroplist)).click();
    }

    public void checkDroplistValues(List<UserTableDropList> values) {
        for (int i = 0; i < values.size(); i++) {
            $(xpath(locatorForDroplist + "/option" + "[" + (i + 1) + "]")).shouldHave(Condition.text(values.get(i).value));
        }
    }
}