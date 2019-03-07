package JDI.pages;

import JDI.entities.User;
import JDI.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;
import org.openqa.selenium.support.FindBy;


@Url("/index.html")
@Title("Home Page")
public class IndexPageJDI extends WebPage {

    private LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = ".m-l8 li")
    public static Menu headerSection;

    @FindBy(css = ".profile-photo")
    private Icon profilePhoto;

    @FindBy(css = ".logout button")
    private Button logoutButton;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void logout() {
        profilePhoto.click();
        logoutButton.click();
    }
}