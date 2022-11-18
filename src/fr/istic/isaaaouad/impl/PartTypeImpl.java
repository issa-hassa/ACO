package fr.istic.isaaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class PartTypeImpl implements PartType {
	private String name;
	private Category category;
	Engine g = new Engine();
	
	PartTypeImpl(String name, Category category){
		this.name = name;
		this.category = category;
		
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public Category getCategory() {
		return this.category;
	}
	

}
