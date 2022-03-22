package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

import java.util.regex.Pattern;

public class MoroccoValidator implements PhoneValidator{

    private PhoneValidator nextValidator;

    @Override
    public void setNextValidator(PhoneValidator validator) {
        this.nextValidator = validator;
    }

    @Override
    public CustomerResponse validate(CustomerResponse customerResponse) {
        if (customerResponse.getCountry() == null){
            if (Pattern.matches("\\(212\\)\\ ?[5-9]\\d{8}$",customerResponse.getPhone())){
                customerResponse.setCountry(Country.MOROCCO);
                customerResponse.setValid(true);
            }else if (Pattern.matches("\\(212\\)\\ ? .*$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.MOROCCO);
            }else{
                return nextValidator.validate(customerResponse);
            }

        }
        return customerResponse;
    }
}
