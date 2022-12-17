package fr.istic.isaaaouad.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ConfigurationImpl implements Configuration {
	ComptabilityManagerImpl cm ;
	Set<PartType> selectedPartype;
	public ConfigurationImpl(ComptabilityManagerImpl cm, Set<PartType> selectedPartype) {
		this.cm = cm;
		this.selectedPartype = selectedPartype;
	}
	@Override
	public boolean isValid() {
		for(PartType selected : selectedPartype ){
			for(PartType incompatible : cm.getIncompatibilities(selected)){
				if(selectedPartype.contains(incompatible)) return false;
			}
			for(PartType required: cm.getRequirements(selected)){
				if(!selectedPartype.contains(required)) return false;
			}

		}
		return true;
	}

	@Override
	public boolean isComplete() {
		boolean enginePresent = false;
		boolean interiorPresent = false;
		boolean exteriorPresent = false;
		boolean transmissionPresent = false;
		for(PartType selected : selectedPartype){
			enginePresent = (selected.getCategory() instanceof Engine);
			interiorPresent = (selected.getCategory() instanceof Engine);
			exteriorPresent = (selected.getCategory() instanceof Engine);
			transmissionPresent = (selected.getCategory() instanceof Engine);
			if(enginePresent && interiorPresent && exteriorPresent && transmissionPresent) {
				return true;
			}
		}
		return false;

	}

	@Override
	public Set<PartType> getSelectedParts() {
		
		return Collections.unmodifiableSet(this.selectedPartype);
	}

	@Override
	public void selectPart(PartType chosenPart) {

		selectedPartype.add(chosenPart);

	}

	@Override
	public PartType getSelectionForCategory(Category category) {
		for (PartType partType : selectedPartype) {
			if(partType.getCategory() == category) return partType;
		}
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
	
		selectedPartype.removeIf(partType -> (partType.getCategory()  == categoryToClear));
		
	
		
	}

	@Override
	public void clear() {
		this.cm = new ComptabilityManagerImpl();
		
		this.selectedPartype.removeAll(selectedPartype);
	}

}
