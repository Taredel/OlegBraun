package JDI.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public enum Colors {
    DEFAULT_COLOR("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String value;

    Colors(String value) {
        this.value = value;
    }
}
