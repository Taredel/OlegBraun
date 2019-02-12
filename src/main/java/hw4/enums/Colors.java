package hw4.enums;

public enum Colors {
    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    COLOR("Colors");

    public String value;

    Colors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
