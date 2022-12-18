package fr.istic.issaouad.impl;


import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class Exterior extends PartImpl {


	Utils.Color color;
	public Exterior(PartType type) {
		super(type);
	}

	public String getColor() {
		return color.name();
	}

	public void setColor(String color) {
		this.color.valueOf(color);
	}


}
