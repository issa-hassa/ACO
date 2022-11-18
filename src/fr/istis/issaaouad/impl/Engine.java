package fr.istis.issaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

public class Engine implements Category {
	
	private String name;
	
	Engine(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
 
}
