package fr.istic.issaouad.impl;


import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.PartType;

import java.util.Arrays;
import java.util.HashSet;

public class Interior extends PartImpl{
	Utils.Quality quality;
	public Interior(PartType type) {
		super(type);
	}

	public String getQuality() {
		return quality.name();
	}

	public void setQuality(String quality) {
		if(!this.getAvailablePropertyValues(Utils.QUALITY).contains(quality)){
			throw new IllegalArgumentException(quality + "is not a possible value for quality propriety");
		}
		this.quality.valueOf(quality);
	}

	public static   class IN extends Interior{

		public IN(PartType type) {
			super(type);
			this.quality = Utils.Quality.STANDARD;
			addProperty(
					Utils.QUALITY,
					this :: getQuality,
					this :: setQuality,
					new HashSet<>(Arrays.asList(Utils.Quality.STANDARD.name()))
			);
		}
	}

	public static class IH extends Interior{

		public IH(PartType type) {
			super(type);
			this.quality = Utils.Quality.HIGH;
			addProperty(
					Utils.QUALITY,
					this :: getQuality,
					this :: setQuality,
					new HashSet<>(Arrays.asList(Utils.Quality.HIGH.name()))
			);
		}
	}
	public static class IS extends Interior{

		public IS(PartType type) {
			super(type);
			this.quality = Utils.Quality.SPORT;
			addProperty(
					Utils.QUALITY,
					this :: getQuality,
					this :: setQuality,
					new HashSet<>(Arrays.asList(Utils.Quality.SPORT.name()))
			);
		}
	}
}
