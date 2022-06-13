package com.chainsys.springproject.beans;
//multiple factory methods in our class
//Calendar factory is also called as initiating bean because method int this bean instantiates object for other beans.
public class CalendarFactory {
	//the factory method is not static here because constructor not private here.
	public Calendar createCalendar() {
		//The calendar constructor is default access modifier so,can be called here
		//The calendar class and the calendar factory class are both in the same package
		return new Calendar();
	}
	public Appointments createAppointments() {
		return new Appointments();
	}

}
