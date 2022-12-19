package fr.istic.issaouad.impl;


import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.HashSet;

public class Exterior extends PartImpl {


	Utils.Color color;
	public Exterior(PartType type) {
		super(type);
	}

	public String getColor() {
		return color.name();
	}

	public void setColor(String color) throws IllegalArgumentException {
		if(!getAvailablePropertyValues(Utils.PAINT).contains(color)){
			throw new IllegalArgumentException(color + "is not a possible value for XC paint color");
		}
		this.color.valueOf(color);
	}

	public static   class XC extends Exterior {

		public XC(PartType type) {
			super(type);
			this.color = Utils.Color.CLASSIC;
			addProperty(Utils.PAINT,
					this :: getColor,
					this :: setColor,
					new HashSet<>(Arrays.asList(Utils.Color.CLASSIC.name()))
					);
		}
	}
	public static class XM extends Exterior {

		public XM(PartType type) {
			super(type);
			this.color = Utils.Color.METALLIC;
			addProperty(Utils.PAINT,
					this :: getColor,
					this :: setColor,
					new HashSet<>(Arrays.asList(Utils.Color.METALLIC.name()))
			);
		}
	}
	public static   class XS extends Exterior {

		public XS(PartType type) {
			super(type);
			this.color = Utils.Color.RED;
			addProperty(Utils.PAINT,
					this :: getColor,
					this :: setColor,
					new HashSet<>(Arrays.asList(Utils.Color.RED.name()))
			);
		}
	}


}
