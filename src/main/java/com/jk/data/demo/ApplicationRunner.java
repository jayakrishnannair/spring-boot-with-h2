package com.jk.data.demo;

import java.util.Optional;

import com.jk.data.jpa.Customer;
import com.jk.data.jpa.CustomerRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ApplicationRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application Started !!");
        if (customerRepository == null) {
            logger.info("CR is null !!");
        } else {
            customerRepository.save(new Customer("Boba", "Fett"));
            customerRepository.save(new Customer("Hans", "Solo"));
            for (Customer c : customerRepository.findAll()) {
                logger.info(c);
            }

            Optional<Customer> c = customerRepository.findById(1L);
            if (c.isPresent()) {
                logger.info(c);
            }

            customerRepository.findByLastName("Solo").forEach(a -> logger.info(a));
        }
    }

}