package com.mejustme.validator.services.validators;

public class ParamValidator {

    public boolean isValid(String state, String country) {
        boolean isValidCountry =(country.equalsIgnoreCase("all")) || (Country.findByValue(country) != null);
        boolean isValidState = (state.equalsIgnoreCase("all") || state.equalsIgnoreCase("valid") || state.equalsIgnoreCase("invalid"));
        if (isValidCountry && isValidState) {
            return true;
        }
        return false;
    }
}
