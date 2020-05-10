package com.jk.data.demo;

import com.jk.data.jpa.CustomerRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
		assert (customerRepository != null);
	}

}
