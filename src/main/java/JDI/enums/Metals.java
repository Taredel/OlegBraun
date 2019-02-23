package JDI.enums;

import lombok.ToString;

@ToString
public enum Metals {
    DEFAULT_METAL("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String value;

    Metals(String value) {
        this.value = value;
    }
}
