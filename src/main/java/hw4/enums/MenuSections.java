package hw4.enums;

public enum MenuSections {
    MENU_SECTION_1("SUPPORT"),
    MENU_SECTION_2("DATES"),
    MENU_SECTION_3("COMPLEX TABLE"),
    MENU_SECTION_4("SIMPLE TABLE"),
    MENU_SECTION_5("TABLE WITH PAGES"),
    MENU_SECTION_6("DIFFERENT ELEMENTS");

    public String value;

    MenuSections(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
