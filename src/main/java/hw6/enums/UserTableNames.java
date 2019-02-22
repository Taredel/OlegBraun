package hw6.enums;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public enum UserTableNames {
    ROMAN("Roman"),
    SERGEY_IVAN("Sergey Ivan"),
    VLADZIMIR("Vladzimir"),
    HELEN_BENNETT("Helen Bennet"),
    YOSHI_TANNAMURI("Yoshi Tannamuri"),
    GIOVANNI_ROVELLI("Giovanni Rovelli");

    public String value;

    UserTableNames(String value) {
        this.value = value;
    }
}
