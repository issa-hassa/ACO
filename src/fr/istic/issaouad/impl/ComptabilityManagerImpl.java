package fr.istic.issaouad.impl;

import java.util.*;

import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ComptabilityManagerImpl implements CompatibilityManager {
	HashMap<PartType, Set<PartType>> incompatibilities ;
	HashMap<PartType, Set<PartType>> requirements;


	public ComptabilityManagerImpl() {
		
		this.incompatibilities = new HashMap<>();
		this.requirements = new HashMap<>();
	}

	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		Objects.requireNonNull(reference);
		if(this.incompatibilities.containsKey(reference)){
			return Collections.unmodifiableSet(this.incompatibilities.get(reference));
		}
		return Collections.emptySet();
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		Objects.requireNonNull(reference);
		if(this.requirements.containsKey(reference)) {
			return Collections.unmodifiableSet(this.requirements.get(reference));
		}
		return Collections.emptySet();
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



		if(this.requirements.containsKey(reference)) {

			for(PartType incompPartType : target){
				if(this.getRequirements(reference).contains(incompPartType)){
					throw new RuntimeException("The part :" +incompPartType.getName() + " is required for the part "+ reference.getName());
				}
				if(this.getRequirements(incompPartType).contains(reference)){
					throw new RuntimeException("The part :" +reference.getName() + " is required for the part "+ incompPartType.getName());
				}

			}
		}
		if(this.incompatibilities.containsKey(reference)){
			this.incompatibilities.get(reference).addAll(target);
		}
		else {
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
		Objects.requireNonNull(reference, "the target can't be null");
		Objects.requireNonNull(target,"the reference can't be null");

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
			}
		}

		if(this.requirements.containsKey(reference)){
				this.requirements.get(reference).addAll(target);
		}
		else {
			this.requirements.put(reference, target);
		}

		
	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		Objects.requireNonNull(reference);
		Objects.requireNonNull(target);
		if(this.requirements.containsKey(reference)) {
			if(!this.requirements.get(reference).contains(target)){
				throw new RuntimeException("the reference "+ reference + "dont contain the value "+ target);
			}
			this.requirements.get(reference).remove(target);
		}
		if(this.requirements.isEmpty()) this.requirements.remove(reference);
	}

}
