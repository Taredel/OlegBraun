package JDI.entities;

import JDI.enums.*;
import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static JDI.enums.Colors.RED;
import static JDI.enums.Elements.FIRE;
import static JDI.enums.Elements.WATER;
import static JDI.enums.EvenEnum.EIGTH;
import static JDI.enums.OddsEnum.THREE;
import static JDI.enums.Vegetables.CUCUMBER;
import static JDI.enums.Vegetables.TOMATO;
import static hw4.enums.Metals.SELEN;

@AllArgsConstructor
public class MetalColorsData extends DataClass<MetalColorsData> {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metal;
    private String[] vegetables;

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public static MetalColorsData DEFAULT_DATA = new MetalColorsData(
            new int[]{THREE.digit, EIGTH.digit},
            new String[]{WATER.value, FIRE.value},
            RED.value,
            SELEN.value,
            new String[]{CUCUMBER.value, TOMATO.value});

    public String getOddsRadioButton() {
        return  String.valueOf(summary[0]);
    }

    public String getEvenRadioButton() {
        return  String.valueOf(summary[1]);
    }
}
