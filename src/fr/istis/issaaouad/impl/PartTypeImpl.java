package fr.istis.issaaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class PartTypeImpl implements PartType{
	private String name;
	private Category cat;
	public PartTypeImpl(String name, Category cat) {
		this.cat = cat;
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Category getCategory() {
		return cat;
	}
}
