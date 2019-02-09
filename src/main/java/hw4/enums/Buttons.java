package hw4.enums;

public enum Buttons {
    BUTTON_1("Default Button"),
    BUTTON_2("Button");

    public String value;

    Buttons(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
