package fr.istis.issaaouad.impl;

import java.util.Collections;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityChecker;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ConfiguratorImpl implements Configurator {
	private Set<Category> categories;
	private Configuration config;
	private CompatibilityManager cmCh;
	
	@Override
	public Set<Category> getCategories() {
		
		return Collections.unmodifiableSet(this.categories);
	}

	@Override
	public Set<PartType> getVariants(Category category) {
		
		return null;
	}

	@Override
	public Configuration getConfiguration() {
		
		return this.config;
	}

	@Override
	public CompatibilityChecker getCompatibilityChecker() {
		
		return this.cmCh;
	}

}
