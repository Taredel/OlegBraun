package hw3;

import hw3.enums.BenefitTexts;
import hw3.enums.HeaderSection;
import hw3.enums.HomePageData;
import hw3.enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<WebElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

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

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
    }

    public void checkUsername(User user) {
        assertTrue(usernameField.isDisplayed());
        assertEquals(usernameField.getText(), user.getUsername());
    }

    public void checkHeaderSection(HeaderSection[] values) {
        assertEquals(headerSection.size(), 4);
        List<String> actual = headerSection
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (HeaderSection value : values) {
            assertTrue(actual.contains(value.toString()));
        }
    }

    public void checkBenefitImages() {
        assertEquals(benefitImages.size(), 4);
        for (WebElement image : benefitImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkBenefitTexts(BenefitTexts[] values) {
        assertEquals(benefitTexts.size(), 4);
        List<String> actual = benefitTexts
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (BenefitTexts value : values) {
            assertTrue(actual.contains(value.toString()));
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