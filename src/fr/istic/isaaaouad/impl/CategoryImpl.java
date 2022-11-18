package fr.istic.isaaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

public abstract class CategoryImpl implements  Category {
	private String name ;
	@Override
	public String getName() {
		
		return this.name;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Category)) return false;
		return ((Category)o).getName() == this.getName();
	}
}
