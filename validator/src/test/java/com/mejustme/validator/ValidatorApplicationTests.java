package com.mejustme.validator;

import com.mejustme.validator.entities.Customer;
import com.mejustme.validator.responses.CustomerResponse;
import com.mejustme.validator.respositories.CustomerRepository;
import com.mejustme.validator.services.CustomerService;
import com.mejustme.validator.services.validators.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ValidatorApplicationTests {

    @Autowired
    CustomerService customerService;

    @MockBean
    CustomerRepository customerRepository;


    @Test
    public void testValidation() {
        List<Customer> customers = Arrays.asList(
                new Customer(1,"Walid Hammadi","(212) 6007989253"),
                new Customer(2,"Yosaf Karrouch","(212) 698054317"),
                new Customer(3,"Alberto","(258) 847651504"),
                new Customer(4,"Marco","(258) 84330678235"),
				new Customer( 5,"Antonio","(256) 3142345678"),
                new Customer(6,"Albert","(256) 714660221"),
                new Customer(7,"Karim","(251) 9119454961"),
                new Customer(8,"Kelly","(251) 914148181"),
                new Customer(9, "Ephrem","(237) 678009592"),
                new Customer(10,"Daniel","(237) 6A0311634"),
                new Customer(10,"Daniel3","(254) 6A0311634")
        );
        Mockito.when(customerRepository.findAll()).thenReturn( customers);
        List<CustomerResponse> responses = customerService.getCustomers("all","all");

        Assertions.assertEquals(false, responses.get(0).isValid());
        Assertions.assertEquals(Country.MOROCCO.getValue(),responses.get(0).getCountry());

        Assertions.assertEquals(true,responses.get(1).isValid());
        Assertions.assertEquals(Country.MOROCCO.getValue(), responses.get(1).getCountry());

        Assertions.assertEquals(true,responses.get(2).isValid());
        Assertions.assertEquals(Country.MOZAMBIQUE.getValue(),responses.get(2).getCountry());

        Assertions.assertEquals(false,responses.get(3).isValid());
        Assertions.assertEquals(Country.MOZAMBIQUE.getValue(), responses.get(3).getCountry());

        Assertions.assertEquals(false,responses.get(4).isValid());
        Assertions.assertEquals(Country.UGANDA.getValue(),responses.get(4).getCountry());

        Assertions.assertEquals(true,responses.get(5).isValid());
        Assertions.assertEquals(Country.UGANDA.getValue(),responses.get(5).getCountry());

        Assertions.assertEquals(false,responses.get(6).isValid());
        Assertions.assertEquals(Country.ETHIOPIA.getValue(),responses.get(6).getCountry());

        Assertions.assertEquals(true,responses.get(7).isValid());
        Assertions.assertEquals(Country.ETHIOPIA.getValue(),responses.get(7).getCountry());

        Assertions.assertEquals(true,responses.get(8).isValid());
        Assertions.assertEquals(Country.CAMEROON.getValue(),responses.get(8).getCountry());

        Assertions.assertEquals(false,responses.get(9).isValid());
        Assertions.assertEquals(Country.CAMEROON.getValue(),responses.get(9).getCountry());

        Assertions.assertEquals(false,responses.get(10).isValid());
        Assertions.assertEquals(Country.NAN.getValue(),responses.get(10).getCountry());

    }

}
