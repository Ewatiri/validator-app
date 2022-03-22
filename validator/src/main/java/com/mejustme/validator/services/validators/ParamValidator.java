package com.mejustme.validator.services.validators;

public class ParamValidator {

    public boolean isValid(String state, String country) {
        if (state.equalsIgnoreCase("all") && country.equalsIgnoreCase("all")) {
            return true;
        }
        boolean isValidCountry = Country.findByValue(country) != null;
        boolean isValidState = (state.equalsIgnoreCase("all") || state.equalsIgnoreCase("valid") || state.equalsIgnoreCase("invalid"));
        if (isValidCountry && isValidState) {
            return true;
        }

        return false;
    }
}
