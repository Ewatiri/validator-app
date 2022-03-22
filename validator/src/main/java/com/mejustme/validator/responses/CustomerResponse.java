package com.mejustme.validator.responses;

import com.mejustme.validator.entities.Customer;
import com.mejustme.validator.services.validators.Country;

public class CustomerResponse {

    private String name;
    private String phone;
    private String countryCode;
    private String country;
    private boolean isValid;

    public CustomerResponse(Customer customer){
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.countryCode = new StringBuilder().append("+").append(customer.getPhone().substring(1,4)).toString();
        this.country = null;
        this.isValid = false;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country.getValue();
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String toString(){
        return "Phone--"+getPhone()+"--"+getCountry()+"--"+isValid();
    }
}
