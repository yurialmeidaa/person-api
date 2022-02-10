package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    NOME("HOME"),
    MOBILE("MOBILE"),
    COMMERCIAL("COMMERCIAL");

    private final String description;
}
