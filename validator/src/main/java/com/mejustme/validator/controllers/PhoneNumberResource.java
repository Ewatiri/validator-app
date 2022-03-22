package com.mejustme.validator.controllers;

import com.mejustme.validator.responses.CustomerResponse;
import com.mejustme.validator.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/phones")
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneNumberResource {

    @Autowired
    CustomerService service;

    @GetMapping("/all")
    public List<CustomerResponse> getAll(@RequestParam(defaultValue = "all") String state,
                                         @RequestParam(defaultValue = "all") String country){
        return service.getCustomers(state, country);
    }
}
