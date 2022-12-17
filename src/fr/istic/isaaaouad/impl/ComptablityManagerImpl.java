package fr.istic.isaaaouad.impl;

import java.util.*;

import com.sun.javafx.collections.MappingChange.Map;

import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import jdk.nashorn.internal.ir.annotations.Immutable;

public class ComptablityManagerImpl implements CompatibilityManager {
	HashMap<PartType, Set<PartType>> incompatibilities = new HashMap <PartType, Set<PartType>>();
	HashMap<PartType, Set<PartType>> requirements =  new HashMap <PartType, Set<PartType>>();


	public ComptablityManagerImpl(HashMap<PartType, Set<PartType>> incompatibilities, HashMap<PartType, Set<PartType>> requirements) {
		
		this.incompatibilities = incompatibilities;
		this.requirements = requirements;
	}

	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		Objects.requireNonNull(reference);
		if(this.incompatibilities.containsKey(reference)){
			return Collections.unmodifiableSet(this.incompatibilities.get(reference));
		}
		return new HashSet<PartType>();
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		Objects.requireNonNull(reference);
		if(this.requirements.containsKey(reference)) {
			return Collections.unmodifiableSet(this.requirements.get(reference));
		}
		return new HashSet<PartType>();
	}

	/**
	 * Ajout d'un ensemeble des incomptabilités à la reference
	 *
	 * @param reference la reference du type de la piece
	 * @param target l'ensemble des pieces qui sont incompatible avec la piece reference
	 * @throws  RuntimeException  si refernece requiert l'un des elements de target ou l'inverse
	 */

	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(target);



		if(this.incompatibilities.containsKey(reference)) {

			for(PartType incompPartType : target){
				if(getRequirements(reference).contains(incompPartType)){
					throw new RuntimeException("The part :" +incompPartType.getName() + " is required for the part "+ reference.getName());
				}
				if(getRequirements(incompPartType).contains(reference)){
					throw new RuntimeException("The part :" +reference.getName() + " is required for the part "+ incompPartType.getName());
				}
				if(!getIncompatibilities(reference).contains(incompPartType)){
					this.incompatibilities.get(reference).add(incompPartType);
				}
			}
		}
		else{
			this.incompatibilities.put(reference, target);
		}
		
		
	}

	/**
	 *
	 * @param reference la reference du type de la piece
	 * @param target  enleve target de la liste d'incompatibilité de reference
	 */
	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(target);

		if(this.incompatibilities.containsKey(reference)) {
			this.incompatibilities.get(reference).remove(target);

		}


		
		
	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(target);



		if(this.incompatibilities.containsKey(reference)) {

			for(PartType incompPartType : target){
				if(getIncompatibilities(reference).contains(incompPartType)){
					throw new RuntimeException("The part :" +incompPartType.getName() + " is incompatible with for the part "+ reference.getName());
				}
				if(getIncompatibilities(incompPartType).contains(reference)){
					throw new RuntimeException("The part :" +reference.getName() + " is incompatible with the part "+ incompPartType.getName());
				}
				if(!getIncompatibilities(reference).contains(incompPartType)){
					this.incompatibilities.get(reference).add(incompPartType);
				}
			}
		}
		else{
			this.incompatibilities.put(reference, target);
		}
		
	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(target);
		if(this.requirements.containsKey(reference)) {
			this.requirements.get(reference).remove(target);
		}
	}

}
