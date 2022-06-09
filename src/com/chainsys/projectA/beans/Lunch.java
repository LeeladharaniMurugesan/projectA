package com.chainsys.projectA.beans;

public class Lunch {
	public Starters entree;
	public Maincourse mainfood;
	public Desert sweets;
	//Constructor based Dependency injection
	public Lunch(Starters s,Maincourse m,Desert d) {
		System.out.println("Lunch is ready");
		entree=s;
		mainfood=m;
		sweets=d;
	}
	public void serve() {
		System.out.println(entree.name);
		System.out.println(mainfood.name);
		System.out.println(sweets.name);
	}
}
/*
 * Lunch
 * Starters, Chicken,soup,vegroll
 *  Maincourse,SouhIndian,NorthIndian,Chinese
 *  Dessert,IceCream,Sweets,cakes
 */
