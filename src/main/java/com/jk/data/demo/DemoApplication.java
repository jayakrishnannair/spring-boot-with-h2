package com.jk.data.demo;

import com.jk.data.jpa.Customer;
import com.jk.data.jpa.CustomerRepository;
import com.jk.rest.CustomerController;
import com.jk.rest.CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = CustomerController.class)
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
@EntityScan(basePackageClasses = Customer.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner schedulerRunner() {
		return new ApplicationRunner();
	}

	@Bean
	public CustomerService customerService() {
		return new CustomerService();
	}

}
