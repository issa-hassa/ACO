package fr.istic.isaaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

public abstract class CategoryImpl implements  Category {
	private String name ;
	@Override
	public String getName() {
		
		return this.name;
	}


}
