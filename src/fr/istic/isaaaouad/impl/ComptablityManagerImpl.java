package fr.istic.isaaaouad.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;

import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import jdk.nashorn.internal.ir.annotations.Immutable;

public class ComptablityManagerImpl implements CompatibilityManager {
	HashMap<PartType, Set<PartType>> incompatibilities = new HashMap <PartType, Set<PartType>>();
	HashMap<PartType, Set<PartType>> requirements =  new HashMap <PartType, Set<PartType>>();;
	
	

	public ComptablityManagerImpl(HashMap<PartType, Set<PartType>> incompatibilities, HashMap<PartType, Set<PartType>> requirements) {
		
		this.incompatibilities = incompatibilities;
		this.requirements = requirements;
	}

	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		
		return Collections.unmodifiableSet(this.incompatibilities.get(reference));
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		
		return Collections.unmodifiableSet(this.requirements.get(reference));
	}

	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		if(this.incompatibilities.containsKey(reference)) { this.incompatibilities.get(reference).addAll(target);}
		else{
			this.incompatibilities.put(reference, target);
		}
		
		
	}

	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		if(!this.incompatibilities.containsKey(reference)) {
			return;
		}
		this.incompatibilities.get(reference).remove(target);
		
		
	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		if(this.requirements.containsKey(reference)) { this.requirements.get(reference).addAll(target);}
		else{
			this.requirements.put(reference, target);
		}
		
	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		if(!this.requirements.containsKey(reference)) {
			return;
		}
		this.requirements.get(reference).remove(target);
		
		
	}

}
