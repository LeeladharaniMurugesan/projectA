package com.chainsys.projectA.getbeans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chainsys.projectA.beans.AppConfig;
import com.chainsys.projectA.beans.Employee;
public class TestAnnotationConfig {
	public static void testA() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp =ac.getBean(Employee.class);
		emp.setName("cat");
		emp.setId(102);
		emp.print();
		Employee emp2 =ac.getBean(Employee.class);
	}

}
