package hw3.enums;

public enum TextsUnderImages {
    TEXT_UNDER_IMAGE_1("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    TEXT_UNDER_IMAGE_2("To be flexible and\n" + "customizable"),
    TEXT_UNDER_IMAGE_3("To be multiplatform"),
    TEXT_UNDER_IMAGE_4("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
            + "wish to get more…");

    private String value;

    TextsUnderImages(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
