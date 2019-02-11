package hw3.enums;

public enum BenefitTexts {
    BENEFIT_TEXT_1("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    BENEFIT_TEXT_2("To be flexible and\n" + "customizable"),
    BENEFIT_TEXT_3("To be multiplatform"),
    BENEFIT_TEXT_4("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
            + "wish to get more…");

    private String value;

    BenefitTexts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
