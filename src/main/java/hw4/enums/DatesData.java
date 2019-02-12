package hw4.enums;

public enum DatesData {
    LEFT_SLIDER("From"),
    RIGHT_SLIDER("To");

    public String value;

    DatesData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
