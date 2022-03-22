package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

import java.util.regex.Pattern;

public class UgandaValidator implements PhoneValidator{
    private PhoneValidator nextValidator;

    @Override
    public void setNextValidator(PhoneValidator validator) {
        this.nextValidator = validator;
    }

    @Override
    public CustomerResponse validate(CustomerResponse customerResponse) {
        if (customerResponse.getCountry() == null){
            if (Pattern.matches("\\(256\\)\\ ?\\d{9}$",customerResponse.getPhone())){
                customerResponse.setCountry(Country.UGANDA);
                customerResponse.setValid(true);
            }else if (Pattern.matches("\\(256\\)\\ ? .*$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.UGANDA);
            }else{
                customerResponse.setCountry(Country.NAN);
            }

        }
        return customerResponse;
    }
}
