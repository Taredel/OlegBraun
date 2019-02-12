package hw4.enums;

public enum Buttons {
    DEFAULT_BUTTON("Default Button"),
    BUTTON("Button");

    public String value;

    Buttons(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
