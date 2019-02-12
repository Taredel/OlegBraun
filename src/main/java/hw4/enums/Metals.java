package hw4.enums;

public enum Metals {
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    SELEN("SELEN"),
    METAL("metal");

    public String value;

    Metals(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
