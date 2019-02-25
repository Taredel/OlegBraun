package JDI.pages;

import JDI.entities.MetalColorsData;
import JDI.forms.MetalColorsForm;
import JDI.sections.ResultSection;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    private MetalColorsForm metalsColorsForm;
    private ResultSection resultSection;

    public void setNewData(MetalColorsData data) {
        metalsColorsForm.submitData(data);
    }

    public void checkLog(MetalColorsData data) {
        resultSection.checkData(data);
    }
}
