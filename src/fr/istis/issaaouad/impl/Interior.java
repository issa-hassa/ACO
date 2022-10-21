package fr.istis.issaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;

public class Interior implements Category{
	
	private String name;
	
	Interior(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

}

}
