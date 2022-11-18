package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityManager extends CompatibilityChecker {
	/**
	 * 
	 * @param reference la reference du type de la piece
	 * @param target l'ensemble des pieces qui sont incompatible avec la piece reference
	 */

    void addIncompatibilities(PartType reference, Set<PartType> target);
    /**
     * 
     * @param reference la reference du type de la piece
     * @param target  l'ensemble des piecesà enlever
     */

    void removeIncompatibility(PartType reference, PartType target);
    /**
     * 
     * @param reference la reference de la piece 
     * @param target l'ensemble des pieces requises pour la piece reference
     */

    void addRequirements(PartType reference, Set<PartType> target);
    /**
     * 
     * @param reference la reference de la piece 
     * @param target l'ensemble des pieces à enlever de la liste des pieces requises pour la piece reference
     */

    void removeRequirement(PartType reference, PartType target);

}
