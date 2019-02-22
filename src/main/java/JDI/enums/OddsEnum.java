package JDI.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum OddsEnum {
    DEFAULT_ODDS("1", 1),
    ONE("1", 1),
    THREE("3", 3),
    FIVE("5", 5),
    SEVEN("7", 7);

    public final String value;
    public final int digit;
}
