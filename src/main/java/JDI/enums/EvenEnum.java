package JDI.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum EvenEnum {
    DEFAULT_SUM("3", 3),
    DEFAULT_EVEN("2", 2),
    TWO("2", 2),
    FOUR("4", 4),
    SIX("6", 6),
    EIGTH("8", 8);

    public final String value;
    public final int digit;
}
