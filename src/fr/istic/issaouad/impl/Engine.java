package fr.istic.issaouad.impl;

import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public  class Engine extends PartImpl {

	protected Utils.EngineType engineType;

	protected String power;


	public Engine(PartType type) {
		super(type);
	}

	protected String getEngineType() {
		return engineType.name();
	}

	protected void setEngineType(String type) throws IllegalArgumentException {
		if (!getAvailablePropertyValues(Utils.TYPE).contains(type)) {
			throw new IllegalArgumentException(type + " is not a type property");
		}
		this.engineType.valueOf(type);

	}

	protected String getPower() {
		return this.power;
	}

	protected void setEnginePower(String type) throws IllegalArgumentException {
		if (!getAvailablePropertyValues(Utils.POWER).contains(type)) {
			throw new IllegalArgumentException(type + " is not a power property");
		}
		this.power = type;
	}


	public static class EG100 extends Engine {

		public EG100(PartType type) {
			super(type);
			this.power = Utils.KW_100;
			this.engineType = Utils.EngineType.GASOLINE;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_100))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.GASOLINE.name()))
			);
		}
	}

	public static class EG133 extends Engine {

		public EG133(PartType type) {
			super(type);
			this.power = Utils.KW_133;
			this.engineType = Utils.EngineType.GASOLINE;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_133))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.GASOLINE.name()))
			);
		}
	}

	public static class EG210 extends Engine {

		public EG210(PartType type) {
			super(type);
			this.power = Utils.KW_210;
			this.engineType = Utils.EngineType.DIESEL;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_210))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.GASOLINE.name()))
			);


		}
	}

	public static class ED110 extends Engine {

		public ED110(PartType type) {
			super(type);
			this.power = Utils.KW_110;
			this.engineType = Utils.EngineType.DIESEL;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_110))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.DIESEL.name()))
			);
		}

	}

	public static class ED180 extends Engine {

		public ED180(PartType type) {
			super(type);
			this.power = Utils.KW_180;
			this.engineType = Utils.EngineType.DIESEL;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_180))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.DIESEL.name()))
			);
		}
	}

	public static class EH120 extends Engine {

		public EH120(PartType type) {
			super(type);
			this.power = Utils.KW_120;
			this.engineType = Utils.EngineType.HYBRID;
			addProperty(
					Utils.POWER,
					this::getPower,
					this::setEnginePower,
					new HashSet<>(Arrays.asList(Utils.KW_120))
			);
			addProperty(Utils.TYPE,
					this::getEngineType,
					this::setEngineType,
					new HashSet<>(Arrays.asList(Utils.EngineType.HYBRID.name()))
			);
		}
	}
}



