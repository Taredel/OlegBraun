package hw4.enums;

public enum Checkboxes {
    CHECKBOX_1("WATER"),
    CHECKBOX_2("EARTH"),
    CHECKBOX_3("WIND"),
    CHECKBOX_4("FIRE");

    public String value;

    Checkboxes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
