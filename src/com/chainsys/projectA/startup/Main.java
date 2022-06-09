package com.chainsys.projectA.startup;
import com.chainsys.projectA.getbeans.TestAnnotationConfig;
import com.chainsys.projectA.getbeans.TestClasspatXml;
public class Main {

	public static void main(String[] args) {
		//TestClasspatXml.testFactoryMethod() ;
		//TestClasspatXml.testLunchFactory();
		TestAnnotationConfig.testA();
		TestClasspatXml.testSetterDi();
	}
}//constructor automatically invoked when application conext is loaded
//First JVM gets loaded
// Main method gets executed
// ApplicationContext is loaded
// ApplicationContext read xml configuration file
// ApplicationContext pre loads one object for each bean in the config file 
//        if dean is not marked as lazy-init ="true"
// lazy -init this inform springContainer not to pre-load object for this bean
// By default Spring early loads objects in memory
// For lazy-init beans object is created only when the get bean method is called
// For pre-init beans getBean() returns the reference of preloaded object
// By default only one object for every ban is created(Singleton)
//Singleton : atleast one object for every class but not more han one object
// Sring for lay-init beans created asingle object on firstcall of getBean () method 
// and then uses that object for future getBean() method calls.