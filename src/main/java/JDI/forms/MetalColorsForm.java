package JDI.forms;

import JDI.entities.MetalColorsData;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static JDI.enums.Vegetables.DEFAULT_VEGETABLES;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class MetalColorsForm extends Form<MetalColorsData> {

    @Css("[id='odds-selector']")
    private RadioButtons oddsRadiobutton;

    @Css("[id='even-selector']")
    private RadioButtons evenRadiobutton;

    @Css(".vertical-group label")
    private List<WebElement> elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
            list = "li", expand = ".caret")
    private Droplist colors;

    @Css(".metals [type='text']")
    private TextField metals;

    @JDropdown(root = "div[id=vegetables]",
            list = "li", expand = ".caret")
    private Droplist vegetables;

    @Css("#submit-button")
    private Button submit;

    public void submitData(MetalColorsData data) {
        oddsRadiobutton.select(data.getOddsRadioButton());
        evenRadiobutton.select(data.getEvenRadioButton());
        for (WebElement webElement : elements) {
            for (String element : data.getElements()) {
                if (webElement.getText().contains(element)) webElement.click();
            }
        }
        colors.select(data.getColor());
        metals.setValue(data.getMetals());
        vegetables.select(DEFAULT_VEGETABLES);
        Arrays.stream(data.getVegetables()).forEach(vegetable -> vegetables.select(vegetable));
        submit.click();
    }
}