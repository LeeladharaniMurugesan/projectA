package com.chainsys.projectA.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Bean;
import com.chainsys.projectA.beans.Employee;
import com.chainsys.projectA.beans.Customer;
@Configuration
public class AppConfig {
@Bean
@Scope(value="prototype")
	public Employee employee() {
	return new Employee();
}

@Bean
	public Customer customer() { 
	return new Customer();
}
}
