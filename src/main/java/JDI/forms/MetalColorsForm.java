package JDI.forms;

import JDI.entities.MetalColorsData;
import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static JDI.enums.Vegetables.DEFAULT_VEGETABLES;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class MetalColorsForm extends Form<MetalColorsData> {

    @Css("[id='odds-selector']")
    private RadioButtons oddsRadiobutton;

    @Css("[id='even-selector']")
    private RadioButtons evenRadiobutton;

    @Css(".vertical-group p")
    private Checklist elements;

    @Css(".colors li")
    private Dropdown color;

    @Css("[title='Colors']")
    private Icon openColor;

    @Css(".metals [type='text']")
    private TextField metals;

    @FindBy(css = "#salad-dropdown button")
    private Icon openVegetables;

    @Css("#salad-dropdown label")
    private Checklist vegetables;

    @Css("#submit-button")
    private Button submit;

    public void submitData(MetalColorsData newData) {
        oddsRadiobutton.select(newData.getOddsRadioButton());
        evenRadiobutton.select(newData.getEvenRadioButton());
        elements.check(newData.getElements());
        openColor.click();
        color.select(newData.getColor());
        metals.setValue(newData.getMetal());
        submit.click();
    }
}
