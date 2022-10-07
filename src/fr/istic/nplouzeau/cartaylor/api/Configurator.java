package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface Configurator {
/**
 * 
 * @return la liste des categories
 */
    Set<Category> getCategories();
    /**
     * 
     * @param category la categorie
     * @return la liste des variants de cette catgories
     */

    Set<PartType> getVariants(Category category);
/**
 * 
 * @return la configuration 
 */
    Configuration getConfiguration();
/**
 * 
 * @return 
 */
    CompatibilityChecker getCompatibilityChecker();

}
