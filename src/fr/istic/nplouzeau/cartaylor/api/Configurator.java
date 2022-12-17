package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;       

public interface Configurator {

    Set<Category> getCategories();
    CompatibilityChecker getCompatibilityChecker();

}
