package com.mejustme.validator.services.validators;

import com.mejustme.validator.responses.CustomerResponse;

public interface PhoneValidator {

    void setNextValidator(PhoneValidator validator);

    CustomerResponse validate(CustomerResponse customerResponse);

}
