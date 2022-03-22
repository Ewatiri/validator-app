package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

import java.util.regex.Pattern;

public class MozambiqueValidator implements PhoneValidator{

    private PhoneValidator nextValidator;

    @Override
    public void setNextValidator(PhoneValidator validator) {
        this.nextValidator = validator;
    }

    @Override
    public CustomerResponse validate(CustomerResponse customerResponse) {
        if (customerResponse.getCountry() == null){
            if (Pattern.matches("\\(258\\)\\ ?[28]\\d{7,8}$",customerResponse.getPhone())){
                customerResponse.setCountry(Country.MOZAMBIQUE);
                customerResponse.setValid(true);
            }else if (Pattern.matches("\\(258\\)\\ ? .*$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.MOZAMBIQUE);
            }else{
                return nextValidator.validate(customerResponse);
            }

        }
        return customerResponse;
    }
}
