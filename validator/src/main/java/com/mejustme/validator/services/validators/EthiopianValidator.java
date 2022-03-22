package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

import java.util.regex.Pattern;

public class EthiopianValidator implements PhoneValidator{

    private PhoneValidator nextValidator;

    @Override
    public void setNextValidator(PhoneValidator validator) {
            this.nextValidator = validator;
    }

    @Override
    public CustomerResponse validate(CustomerResponse customerResponse) {
        if (customerResponse.getCountry() == null){
            if (Pattern.matches("\\(251\\)\\ ?[1-59]\\d{8}$",customerResponse.getPhone())){
                customerResponse.setCountry(Country.ETHIOPIA);
                customerResponse.setValid(true);
            }else if (Pattern.matches("\\(251\\)\\ ? .*$", customerResponse.getPhone())){
                customerResponse.setCountry(Country.ETHIOPIA);
            }else{
                return nextValidator.validate(customerResponse);
            }

        }
        return customerResponse;
    }
}
