package fr.istis.issaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;

public class Transmission implements Category{
	
	private String name;
	
	Transmission(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

}
