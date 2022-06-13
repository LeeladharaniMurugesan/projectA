package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; //Child

import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.Scoreboard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;
public class TestClasspatXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(80);
		emp.setName("leela");
		emp.print();
	}
	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//Employee emp1 =  ac.getBean(Employee.class);//overloaded method of getBean(Class) return object of the class 
		Employee emp =  (Employee) ac.getBean("emp");//overloaded method of getBean(String) return Object,type cast is required
		emp.setId(80);
		emp.setName("Karishma");
		emp.print();
		
		Customer c = ac.getBean(Customer.class);
		c.setId(102);
		c.setName("Murugesan");
		c.print();
	}
	public static void testlazyinit() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp =  ac.getBean(Employee.class);
		Customer c = ac.getBean(Customer.class); //getBean() return type object
		// lazy -init ="true" for customer.An object is created now(firstcall to getBean () method for Customer.class)
		Employee emp1 =  ac.getBean(Employee.class);
		Customer c1 = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(c.hashCode());
	   System.out.println(emp1.hashCode());
		System.out.println(c1.hashCode());
		
	}
	public static void testPrototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Actor hero =ac.getBean(Actor.class);
//		Actor heroin =ac.getBean(Actor.class);
//		Actor comedian =ac.getBean(Actor.class);
//		Actor friends =ac.getBean(Actor.class);
//		System.out.println(hero.hashCode());
//		System.out.println(heroin.hashCode());
//		System.out.println(comedian.hashCode());
//		System.out.println(friends.hashCode());
		
	} 
	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}
	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Scoreboard sb = ac.getBean("scoreboard",Scoreboard.class);
		sb.targetScore=200;
		System.out.println(sb.targetScore);
		Scoreboard sb2 = ac.getBean("scoreboard1",Scoreboard.class);
		System.out.println(sb2.targetScore);
		
	}
	public static void testCalendarFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calendar t1=ac.getBean(Calendar.class);
		t1.day=9;
		t1.month="june";
		t1.year=2022;
		System.out.println(t1.day);
		System.out.println(t1.month);
		System.out.println(t1.year);
	}
	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch=ac.getBean("nvsilunch",Lunch.class);
		Lunch vsilunch=ac.getBean("vsilunch",Lunch.class);
		Lunch nilunch=ac.getBean("nilunch",Lunch.class);
		Lunch chlunch=ac.getBean("chlunch",Lunch.class);
		nvsilunch.serve();
		System.out.println("------");
		vsilunch.serve();
		System.out.println("------");
		nilunch.serve();
		System.out.println("------");
		chlunch.serve();
		
	}
	public static void testSetterDi() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp =ac.getBean("emp2",Employee.class);
		emp.print();
	}
	public static void testLifeCycle() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean lf =ac.getBean(LifeCycleBean.class);
		lf.print();
		
		lf=null;
		//System.gc();
		ac.close();
		ac=null;
	}
	public static void testInitDesposeBean() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Lc.xml");
		InitDesposeBean lf =ac.getBean(InitDesposeBean.class);
		lf.print();
	}
	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc lf =ac.getBean(AnnotationLc.class);
		lf.print();
		lf = null;
		ac.close();
	}
	public static void testAutoWire() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Autowire.xml");
		Car lf =ac.getBean("car",Car.class);
		lf.start();
		lf.move();
		lf=null;
		ac.close();
	}
//	public static void testAutowireQualifier() {
//		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Autowire.xml");
//		CarServices cs=ac.getBean(CarServices.class);
//		cs.startTrip();
//		
//	}
}
