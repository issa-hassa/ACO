package fr.istic.nplouzeau.cartaylor.api;


import java.util.Set;

public interface Configuration {

	/**
	 * Verification si la configuration est valide 
	 * @return true si la configuration ets valide et false sinon 
	 */
    boolean isValid();

    
    /**
     * Verification si la configuratin est complete 
     * @return true si la configuration est complete et false sinon 
     */
    boolean isComplete();

    /**
     * 
     * @return un ensemble de des partType des moteurs selectionnés
     */
    Set<PartType> getSelectedParts();
    
	/**
	 * Selectionner un moteur
	 * @param chosenPart
	 */
    void selectPart(PartType chosenPart);
    
    /**
     * 
     * Categorie selectionner 
     * @param category
     * @return a PartType des categorie selectionner
     */
    PartType getSelectionForCategory(Category category);

    /**
     * supprimmer les categorie non selectionner
     * @param categoryToClear
     */
    void unselectPartType(Category categoryToClear);

    /**
     * supprimer toutes les categorie
     */
    void clear();

}
