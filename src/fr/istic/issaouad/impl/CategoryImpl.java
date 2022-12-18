package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

public class CategoryImpl implements  Category {
	private String name ;

	public CategoryImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof CategoryImpl)) return false;
		return ((CategoryImpl)o).getName().equals(this.name);
	}


}
