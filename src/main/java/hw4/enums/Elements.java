package hw4.enums;

public enum Elements {
    WATER("WATER"),
    EARTH("EARTH"),
    WIND("WIND"),
    FIRE("FIRE");

    public String value;

    Elements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
