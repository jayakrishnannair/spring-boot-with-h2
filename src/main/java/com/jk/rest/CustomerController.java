package com.jk.rest;

import java.util.ArrayList;
import java.util.List;

import com.jk.data.jpa.Customer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("A", "B"));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") long id) {
        Customer c = customerService.findById(id);
        if (c == null) {
            throw new CustomerNotFoundException();
        }
        return c;

    }

}