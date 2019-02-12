package hw4.enums;

public enum MenuSections {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    public String value;

    MenuSections(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
