package hw3;

import hw3.enums.HeaderSection;
import hw3.enums.HomePageData;
import hw3.enums.TextsUnderImages;
import hw3.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw3.enums.HomePageData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    private WebDriver driver;

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement usernameField;

    @FindBy(css = "ul.m-l8 > li")
    private List<WebElement> headerSection;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(css = "[name='main-title']")
    private WebElement headline;

    @FindBy(css = "[name='jdi-text']")
    private WebElement textBelowHeadline;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = "[class='epam-logo']")
    private WebElement epamLogo;

    @FindBy(css = "[class='text-center']")
    private WebElement subHeaderText;

    // TODO This locator should be simplified (4 letters at maximum)
    @FindBy(css = "a[ui='link']")
    private WebElement gdiGithub;

    @FindBy(css = "[id='mCSB_1_container']")
    private WebElement leftSection;

    @FindBy(css = "[class='footer-bg']")
    private WebElement footer;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(HomePageData url) {
        driver.get(url.toString());
    }

    public void checkTitle(HomePageData title) {
        assertEquals(driver.getTitle(), title.toString());
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

    // TODO This method should be parameterized by expected list of data
    public void checkHeaderSection(HeaderSection[] values) {
        assertEquals(headerSection.size(), 4);
        for (int i = 0; i < headerSection.size(); i++) {
            assertTrue(headerSection.get(i).isDisplayed());
            assertEquals(headerSection.get(i).getText(), values[i].toString());
        }
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    // TODO This method should be parameterized by expected list of data
    public void checkTextUnderImages(TextsUnderImages[] values) {
        assertEquals(texts.size(), 4);
        for (int i = 0; i < texts.size(); i++) {
            assertTrue(texts.get(i).isDisplayed());
            assertEquals(texts.get(i).getText(), values[i].toString());
        }
    }

    public void checkMainHeaderTexts(HomePageData textHeader, HomePageData textContent) {
        assertEquals(headline.getText().trim(), textHeader.value);
        assertEquals(textBelowHeadline.getText().trim(), textContent.value);
    }

    public void checkIFrame() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkEpamLogoIFrame() {
        driver.switchTo().frame(iframe);
        assertTrue(epamLogo.isDisplayed());
        driver.switchTo().parentFrame();
    }

    public void checkSubHeaderText(HomePageData textSubHeader) {
        assertEquals(subHeaderText.getText(), textSubHeader.value);
    }

    public void checkJdiGithub(HomePageData jdiLink) {
        assertNotNull(gdiGithub.getAttribute("href"));
        assertEquals(gdiGithub.getAttribute("href"), jdiLink.toString());
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}