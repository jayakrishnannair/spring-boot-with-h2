package com.jk.rest;

import java.util.Optional;

import com.jk.data.jpa.Customer;
import com.jk.data.jpa.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    Customer findById(long id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            return c.get();
        }
        return null;

    }

}