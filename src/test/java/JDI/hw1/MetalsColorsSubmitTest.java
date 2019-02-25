package JDI.hw1;

import JDI.JDISite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static JDI.JDISite.indexPageJDI;
import static JDI.JDISite.metalsColorsPage;
import static JDI.entities.MetalColorsData.DEFAULT_DATA;
import static JDI.entities.User.PETER;
import static JDI.pages.IndexPageJDI.headerSection;
import static hw3.enums.HeaderSection.METALS_COLORS;

public class MetalsColorsSubmitTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void jdiTest() {
        //1 open JDI Site
        indexPageJDI.open();

        //2 login as user PETER
        indexPageJDI.login(PETER);

        //3 open Metals & Colors page
        headerSection.select(METALS_COLORS);

        //4 fill and submit form Metals & Colors by Default Data
        metalsColorsPage.setNewData(DEFAULT_DATA);

        //5 check submit log for proper values
        metalsColorsPage.checkLog(DEFAULT_DATA);
    }
}