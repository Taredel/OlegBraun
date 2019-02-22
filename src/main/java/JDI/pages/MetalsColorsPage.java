package JDI.pages;

import JDI.entities.MetalColorsData;
import JDI.forms.MetalColorsForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@Url("/metals-colors.html") @Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    public static MetalColorsForm metalsColorsForm;

    public void setNewData(MetalColorsData newData) {
        metalsColorsForm.submitData(newData);
    }
}
