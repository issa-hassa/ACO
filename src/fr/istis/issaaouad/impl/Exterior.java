package fr.istis.issaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;

public class Exterior implements Category{

	
	private String name;
	
	Exterior (String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
}
