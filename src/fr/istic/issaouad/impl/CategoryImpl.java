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
	public void accept(PrintHtml p) {
		p.visitCategory(this);
	}

	@Override
	public boolean equals(Object obj) {
	    if(!(obj instanceof CategoryImpl)) return false;
		return this.name.equals(((CategoryImpl)obj).getName());
	}




}
