
package fr.istic.nplouzeau.cartaylor.api;


import java.util.Set;

public interface Configuration {

	/**
	 * Verification si la configuration est valide 
	 * @return true si la configuration est valide et false sinon 
	 */
    boolean isValid();

    
    /**
     * Verification si la configuratin est complete 
     * @return true si la configuration est complete et false sinon 
     */
    boolean isComplete();

    /**
     * 
     * @return l'ensemble  des partType  selectionnés
     */
    Set<PartType> getSelectedParts();
    
	/**
	 * Selectionner un part type
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
    void accept(PrintHtml p);
    void clear();

}
