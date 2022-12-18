package fr.istic.issaouad.impl;

import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Engine extends PartImpl {

	protected Utils.EngineType engineType;

	protected String power;

	protected Set<String> typePossibilities;
	protected Set<String> powerPossibilities;


	public Engine(PartType type) {
		super(type);
	}

	protected String getengineType(){
		return engineType.name();
	}
	protected void  setEngineType(String type) throws IllegalArgumentException {
		if(!getAvailablePropertyValues(Utils.TYPE).contains(type)){
			throw new IllegalArgumentException(type + " is not a type property");
		}
		this.engineType.valueOf(type);

	}
	protected String getPower(){
		return this.power;
	}

	protected void  setEnginePower(String type) throws IllegalArgumentException {
		if(!getAvailablePropertyValues(Utils.POWER).contains(type)){
			throw new IllegalArgumentException(type + " is not a power property");
		}
	}

	public static class EG100 extends Engine {

		public EG100(PartType type) {
			super(type);
		}
	}
	public static class EG133 extends Engine {

		public EG133(PartType type) {
			super(type);
		}
	}
	public static class EG210 extends Engine {

		public EG210(PartType type) {
			super(type);
			this.engineType = Utils.EngineType.DIESEL;
			this.typePossibilities = new HashSet<>(Arrays.asList(Utils.EngineType.GASOLINE.name()));
			this.powerPossibilities = new HashSet<>(Arrays.asList(Utils.EngineType.GASOLINE.name()));
			this.power = "100KW";

		}
	}
	public static class ED110 extends Engine {

		public ED110(PartType type) {
			super(type);
		}
	}
	public static class EG180 extends Engine {

		public EG180(PartType type) {
			super(type);
		}
	}
	public static class EH120 extends Engine {

		public EH120(PartType type) {
			super(type);
		}
	}



}
