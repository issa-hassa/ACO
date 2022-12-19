package fr.istic.issaouad.impl;


import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

import java.util.Arrays;
import java.util.HashSet;

public class Transmission extends PartImpl {
	Utils.Transmission transmission;
	String speed ;
	String nbWheels;

	String maxPower;
	public Transmission(PartType type) {
		super(type);
	}

	public String getTransmission() {
		return transmission.name();
	}

	public void setTransmission(String transmission) {
		if(!this.getAvailablePropertyValues(Utils.TRANSMISSION_TYPE).contains(transmission)){
			throw new IllegalArgumentException(transmission + " is not a possbile value of transmssion type propriety");
		}
		this.transmission.valueOf(transmission);
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		if(!this.getAvailablePropertyValues(Utils.TRANSMISSION_SPEED).contains(speed)){
			throw new IllegalArgumentException(speed  + "is not a possbile value of transmssion speed propriety");
		}
		this.speed = speed;
	}

	public String getNbWheels() {
		return nbWheels;
	}

	public void setNbWheels(String nbWheels) {
		if(this.getAvailablePropertyValues(Utils.WHEEL).contains(nbWheels)){
			throw new IllegalArgumentException(nbWheels + "is not a possbile value of transmssion number wheels propriety  ");
		}
		this.nbWheels = nbWheels;
	}

	public String getMaxPower() {

		return maxPower;
	}

	public void setMaxPower(String maxPower) {
		if(this.getAvailablePropertyValues(Utils.MAX_POWER).contains(maxPower)){
			throw new IllegalArgumentException(maxPower + "is not a possbile value of transmssion max power propriety  ");
		}
		this.maxPower = maxPower;
	}

	public static class TM5 extends Transmission {

		public TM5(PartType type) {
			super(type);
			transmission  = Utils.Transmission.MANUEL;
			addProperty(
					Utils.TRANSMISSION_SPEED,
					this :: getSpeed,
					this :: setSpeed,
					new HashSet<>(Arrays.asList(Utils.G_5))
					);
			this.speed = Utils.G_5;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.MANUEL.name()))

			);

		}
	}
	public static class TM6 extends Transmission {

		public TM6(PartType type) {
			super(type);
			transmission  = Utils.Transmission.MANUEL;
			addProperty(
					Utils.TRANSMISSION_SPEED,
					this :: getSpeed,
					this :: setSpeed,
					new HashSet<>(Arrays.asList(Utils.G_6))
			);
			this.speed = Utils.G_6;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.MANUEL.name()))

			);

		}
	}
	public static class TA5 extends Transmission {

		public TA5(PartType type) {
			super(type);
			transmission  = Utils.Transmission.AUTOMATIC;
			addProperty(
					Utils.TRANSMISSION_SPEED,
					this :: getSpeed,
					this :: setSpeed,
					new HashSet<>(Arrays.asList(Utils.G_5))
			);
			this.speed = Utils.G_5;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.AUTOMATIC.name()))

			);

		}
	}
	public static class TS6 extends Transmission {

		public TS6(PartType type) {
			super(type);
			transmission  = Utils.Transmission.SEQUENTIAL;
			addProperty(
					Utils.TRANSMISSION_SPEED,
					this :: getSpeed,
					this :: setSpeed,
					new HashSet<>(Arrays.asList(Utils.G_6))
			);
			this.speed = Utils.G_6;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.SEQUENTIAL.name()))

			);

		}
	}
	public static class TSF7 extends Transmission {

		public TSF7(PartType type) {
			super(type);
			transmission  = Utils.Transmission.SEQUENTIAL;
			addProperty(
					Utils.TRANSMISSION_SPEED,
					this :: getSpeed,
					this :: setSpeed,
					new HashSet<>(Arrays.asList(Utils.G_7))
			);
			this.speed = Utils.G_7;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.SEQUENTIAL.name()))

			);
			addProperty(
					Utils.WHEEL,
					this :: getNbWheels,
					this :: setNbWheels,
					new HashSet<>(Arrays.asList(Utils.WHEELS_4))
			);

		}
	}
	public static class TC120 extends Transmission {

		public TC120(PartType type) {
			super(type);
			transmission  = Utils.Transmission.CONVERTER;
			addProperty(
					Utils.TRANSMISSION_TYPE,
					this :: getTransmission,
					this :: setTransmission,
					new HashSet<>(Arrays.asList(Utils.Transmission.CONVERTER.name()))

			);
			addProperty(
					Utils.MAX_POWER,
					this :: getMaxPower,
					this :: setMaxPower,
					new HashSet<>(Arrays.asList(Utils.MAX_120))
			);

		}
	}
}
