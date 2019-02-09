package hw4.enums;

public enum Colors {
    COLOR_1("RED"),
    COLOR_2("GREEN"),
    COLOR_3("BLUE"),
    COLOR_4("YELLOW");

    public String value;

    Colors(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
