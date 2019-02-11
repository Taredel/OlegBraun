package hw4.enums;

import java.util.ArrayList;
import java.util.List;

public enum DatesData {
    LEFT_SLIDER("From"),
    RIGHT_SLIDER("To");

    public String value;
    // TODO What is the reason of this fields ?
    // TODO You can just separate this Enum class.

    DatesData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
