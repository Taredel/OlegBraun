package hw4.enums;

import java.util.ArrayList;
import java.util.List;

public enum SelenideIndexPageData {
    HOME_PAGE_URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page"),
    DROPDOWN_MENU_SECTION_1("SUPPORT"),
    DROPDOWN_MENU_SECTION_2("DATES"),
    DROPDOWN_MENU_SECTION_3("COMPLEX TABLE"),
    DROPDOWN_MENU_SECTION_4("SIMPLE TABLE"),
    DROPDOWN_MENU_SECTION_5("USER TABLE"),
    DROPDOWN_MENU_SECTION_6("TABLE WITH PAGES"),
    DROPDOWN_MENU_SECTION_7("DIFFERENT ELEMENTS"),
    DROPDOWN_MENU_SECTION_8("PERFORMANCE"),
    DEP_CHECKBOX_1("WATER"),
    DEP_CHECKBOX_2("EARTH"),
    DEP_CHECKBOX_3("WIND"),
    DEP_CHECKBOX_4("FIRE"),
    DEP_RADIOBUTTON_1("GOLD"),
    DEP_RADIOBUTTON_2("SILVER"),
    DEP_RADIOBUTTON_3("BRONZE"),
    DEP_RADIOBUTTON_4("SELEN"),
    DEP_COLOR_1("RED"),
    DEP_COLOR_2("GREEN"),
    DEP_COLOR_3("BLUE"),
    DEP_COLOR_4("YELLOW"),
    LEFT_SLIDER("From"),
    RIGHT_SLIDER("To");

    public String value;
    // TODO What is the reason of this fields ?
    // TODO You can just separate this Enum class.
    public static List<String> checkBox = new ArrayList<>();
    public static List<String> radioButton = new ArrayList<>();
    public static List<String> colors = new ArrayList<>();

    SelenideIndexPageData(String value) {
        this.value = value;
    }

    public static List<String> getDropdownMenuElements() {
        List<String> dropdownMenu = new ArrayList<>();
        dropdownMenu.add(DROPDOWN_MENU_SECTION_1.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_2.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_3.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_4.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_5.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_6.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_7.value);
        dropdownMenu.add(DROPDOWN_MENU_SECTION_8.value);
        return dropdownMenu;
    }

    public static List<String> getLeftSectionMenuElements() {
        List<String> leftSectionMenu = new ArrayList<>();
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_1.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_2.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_3.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_4.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_5.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_6.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_7.value);
        leftSectionMenu.add(DROPDOWN_MENU_SECTION_8.value);
        return leftSectionMenu;
    }

    public static List<String> initCheckBox() {
        checkBox.add(DEP_CHECKBOX_1.value);
        checkBox.add(DEP_CHECKBOX_2.value);
        checkBox.add(DEP_CHECKBOX_3.value);
        checkBox.add(DEP_CHECKBOX_4.value);
        return checkBox;
    }

    public static List<String> initRadioButtons() {
        radioButton.add(DEP_RADIOBUTTON_1.value);
        radioButton.add(DEP_RADIOBUTTON_2.value);
        radioButton.add(DEP_RADIOBUTTON_3.value);
        radioButton.add(DEP_RADIOBUTTON_4.value);
        return radioButton;
    }

    public static List<String> initColors() {
        colors.add(DEP_COLOR_1.value);
        colors.add(DEP_COLOR_2.value);
        colors.add(DEP_COLOR_3.value);
        colors.add(DEP_COLOR_4.value);
        return colors;
    }

    @Override
    public String toString() {
        return value;
    }
}
