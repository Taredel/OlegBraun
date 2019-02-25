package JDI.sections;

import JDI.entities.MetalColorsData;
import JDI.entities.ResultListData;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.complex.DataList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ResultSection extends Section {

    //doesn't work with DataList or TextArea or Text
    @FindBy(css = ".results li")
    private List<WebElement> resultList;

    public void checkData(MetalColorsData data) {
        String[] expectedResult = new ResultListData().getResult(data);
        List<String> actual = resultList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String result : expectedResult) {
            Assert.assertTrue(actual.contains(result));
        }
    }
}
