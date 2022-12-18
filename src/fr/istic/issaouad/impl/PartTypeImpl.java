package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class PartTypeImpl implements PartType {
	private String name;
	private Category category;

	
	public PartTypeImpl(String name, Category category){
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

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PartTypeImpl)) return false;
		return this.name.equals(((PartTypeImpl)obj).getName()) &&
				this.category.equals((((PartTypeImpl)obj)).getCategory());
	}
	

}
