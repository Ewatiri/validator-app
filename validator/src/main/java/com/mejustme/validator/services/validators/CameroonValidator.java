package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

import java.util.regex.Pattern;


public class CameroonValidator implements PhoneValidator{

    private PhoneValidator nextValidator;

    @Override
    public void setNextValidator(PhoneValidator validator) {
        this.nextValidator = validator;
    }

    @Override
    public CustomerResponse validate(CustomerResponse customerResponse) {
        if (customerResponse.getCountry() == null){
            if (Pattern.matches("\\(237\\)\\ ?[2368]\\d{7,8}$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.CAMEROON);
                customerResponse.setValid(true);
            }else if (Pattern.matches("\\(237\\)\\ ? .*$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.CAMEROON);
            }else{
                return nextValidator.validate(customerResponse);
            }

        }
        return customerResponse;

    }
}
