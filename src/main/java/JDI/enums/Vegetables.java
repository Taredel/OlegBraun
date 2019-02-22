package JDI.enums;

public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    DEFAULT_VEGETABLES("Vegetables"),
    ONION("Onion");

    public String value;

    Vegetables(String value) {
        this.value = value;
    }
}
