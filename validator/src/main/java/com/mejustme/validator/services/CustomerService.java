package com.mejustme.validator.services;

import com.mejustme.validator.entities.Customer;
import com.mejustme.validator.responses.CustomerResponse;
import com.mejustme.validator.respositories.CustomerRepository;
import com.mejustme.validator.services.validators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerResponse> getCustomers(String state, String country){
        if (!new ParamValidator().isValid(state, country)){
            return new ArrayList<>();
        }
        PhoneValidator pv1 = new CameroonValidator();
        PhoneValidator pv2 = new EthiopianValidator();
        PhoneValidator pv3 = new MoroccoValidator();
        PhoneValidator pv4 = new MozambiqueValidator();
        PhoneValidator pv5 = new UgandaValidator();

        pv1.setNextValidator(pv2);
        pv2.setNextValidator(pv3);
        pv3.setNextValidator(pv4);
        pv4.setNextValidator(pv5);

        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        boolean isValid= false;
        if (state.equalsIgnoreCase("valid")){
            isValid = true;
        }
        if (state.equalsIgnoreCase("invalid")){
            isValid = false;
        }

        for(Customer c : customers){
            CustomerResponse customerResponse = pv1.validate(new CustomerResponse(c));
            if (state.equalsIgnoreCase("all") && country.equalsIgnoreCase("all")){
                responses.add(customerResponse);
                continue;
            }
            if (customerResponse.isValid() == isValid && customerResponse.getCountry().equalsIgnoreCase("all")){
                responses.add(customerResponse);
                continue;
            }
            if (state.equalsIgnoreCase("all") && customerResponse.getCountry().equalsIgnoreCase(country)){
                responses.add(customerResponse);
                continue;
            }
            if (customerResponse.isValid() == isValid && customerResponse.getCountry().equalsIgnoreCase(country)){
                responses.add(customerResponse);
                continue;
            }
        }

        return responses;
    }
}
