package com.mejustme.validator.services.validators;

public enum Country {

    CAMEROON("Cameroon"),
    MOROCCO("Morocco"),
    ETHIOPIA("Ethiopia"),
    MOZAMBIQUE("Mozambique"),
    UGANDA("Uganda"),
    NAN("NaN");

    private String value;

    Country(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Country findByValue(String value) {
        Country result = null;
        for (Country c : values()) {
            if (c.getValue().equalsIgnoreCase(value)) {
                result = c;
                break;
            }
        }
        return result;
    }
}
