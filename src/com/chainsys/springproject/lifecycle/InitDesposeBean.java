package com.chainsys.springproject.lifecycle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.BeanPostProcessor; //Refer AOP

public class InitDesposeBean implements DisposableBean,InitializingBean{
	private String city;
	private long pinCode;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	// called after setters
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method called");
		
	}
	//similar to destroy-method
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy method called");
		
	}
	public InitDesposeBean() {
		System.out.println("InitDesposeBean object created  " +  hashCode());
	}
	// after constructor
	public void setUp() {
		System.out.println("Starting InitDesposeBean");
	}
	public void close() {
		System.out.println("closing InitDesposeBean");
	}
	public void print() {
		System.out.println("print called InitDesposeBean");
	}


}
