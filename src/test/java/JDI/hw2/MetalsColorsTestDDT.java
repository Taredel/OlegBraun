package JDI.hw2;

import JDI.JDISite;
import JDI.entities.MetalColorsData;
import JDI.dataProviders.JSONReader;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.*;

import java.util.Map;

import static JDI.JDISite.indexPageJDI;
import static JDI.JDISite.metalsColorsPage;
import static JDI.entities.User.PETER;
import static JDI.pages.IndexPageJDI.headerSection;
import static hw3.enums.HeaderSection.METALS_COLORS;

public class MetalsColorsTestDDT {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        PageFactory.initElements(JDISite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        indexPageJDI.logout();
        WebDriverFactory.close();
    }

    @Test(dataProvider = "provider", dataProviderClass = JSONReader.class)
    public void jdiTest(MetalColorsData newData) {
        //1 open JDI Site
        indexPageJDI.open();

        //2 login as user PETER
        indexPageJDI.login(PETER);

        //3 open Metals & Colors page
        headerSection.select(METALS_COLORS);

        //4 fill and submit form Metals & Colors by Default Data
        metalsColorsPage.setNewData(newData);

        //5 check submit log for proper values
        metalsColorsPage.checkLog(newData);
    }
}

