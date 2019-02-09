package hw3.enums;

public enum HeaderSection {

    HEADER_SECTION_TITLE_1("HOME"),
    HEADER_SECTION_TITLE_2("CONTACT FORM"),
    HEADER_SECTION_TITLE_3("SERVICE"),
    HEADER_SECTION_TITLE_4("METALS & COLORS");

    private String value;

    HeaderSection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
