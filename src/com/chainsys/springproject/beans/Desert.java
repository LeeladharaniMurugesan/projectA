package com.chainsys.springproject.beans;

public abstract class Desert {
	public String name;

}

class Icecream extends Desert {
	public Icecream() {
		name ="Strawberry";
	}
}

class Sweets extends Desert {
	public Sweets() {
		name ="laddu";
	}
}

class Cakes extends Desert {
	public Cakes() {
		name ="Redvelvet";
	}
	public Cakes(String name) {
		this.name=name;
	}
}
