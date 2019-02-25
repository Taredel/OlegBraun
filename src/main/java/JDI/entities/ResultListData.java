package JDI.entities;

import static com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.stringToInt;

public class ResultListData {

    private String resultCalculation;

    public String[] getResult(MetalColorsData data) {
        resultCalculation = (Integer.toString(stringToInt(data.getOddsRadioButton()) +
                stringToInt(data.getEvenRadioButton())));
        return new String[]{getLog("Summary: ", resultCalculation),
                getLog("Elements: ", data.getElements()),
                getLog("Color: ", data.getColor()),
                getLog("Metal: ", data.getMetal()),
                getLog("Vegetables: ", data.getVegetables())
        };
    }

    private String getLog(String name, String... values) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (values.length > 1 && i < (values.length - 1)) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
