package fr.istis.issaaouad.impl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;
public class ComptabilitManagerImpl implements CompatibilityManager {
	HashMap<PartType, Set<PartType> > requirement;
	HashMap<PartType, Set<PartType> > incompatibilities;
	
	public ComptabilitManagerImpl() {
		requirement = new HashMap<>();
		incompatibilities = new HashMap<>();
	}
	
	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		
		return Collections.unmodifiableSet(this.incompatibilities.get(reference));
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		
		return Collections.unmodifiableSet(this.requirement.get(reference));
	}

	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		if(incompatibilities.containsKey(reference)) {
			incompatibilities.get(reference).addAll(target);
		}
		else {
			incompatibilities.put(reference, target);
		}
		
	}

	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		incompatibilities.get(reference).remove(target);
		
	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		requirement.get(reference).addAll(target);
		
	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		requirement.get(reference).remove(target);
		
	}

}
