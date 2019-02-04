package hw3;

import hw3.enums.HomePageData;
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
    @FindBy(css = "div.main-content > h3:nth-child(3) > a")
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
    public void checkHeaderSection() {
        assertEquals(headerSection.size(), 4);
        for (int i = 0; i < headerSection.size(); i++) {
            assertTrue(headerSection.get(i).isDisplayed());
            assertEquals(headerSection.get(i).getText(), getHeaderSectionText().get(i));
        }
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    // TODO This method should be parameterized by expected list of data
    public void checkTextUnderImages() {
        assertEquals(texts.size(), 4);
        for (int i = 0; i < texts.size(); i++) {
            assertTrue(texts.get(i).isDisplayed());
            assertEquals(texts.get(i).getText(), getTextsUnderImages().get(i));
        }
    }

    public void checkMainHeaderTexts() {
        assertEquals(headline.getText().trim(), TEXT_HEADER.value);
        assertEquals(textBelowHeadline.getText().trim(), TEXT_CONTENT.value);
    }

    public void checkIFrame() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkEpamLogoIFrame() {
        driver.switchTo().frame(iframe);
        assertTrue(epamLogo.isDisplayed());
        driver.switchTo().parentFrame();
    }

    public void checkSubHeaderText() {
        assertEquals(subHeaderText.getText(), TEXT_SUB_HEADER.value);
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