package hw4.enums;

public enum Radiobuttons {
    RADIOBUTTON_1("GOLD"),
    RADIOBUTTON_2("SILVER"),
    RADIOBUTTON_3("BRONZE"),
    RADIOBUTTON_4("SELEN");

    public String value;

    Radiobuttons(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
