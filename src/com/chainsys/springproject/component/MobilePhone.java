package com.chainsys.springproject.component;

import org.springframework.stereotype.Component;

@Component
public class MobilePhone {
	private long phoneNumber;

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long string) {
		this.phoneNumber = string;
	}

	public MobilePhone() {
		System.out.println("Mobile object created");
	}
}
