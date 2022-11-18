package fr.istis.issaaouad.impl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;

public class ConfigurationImpl implements Configuration{

	Set<PartType> selectedParts;

	CompatibilityManager cm;
	public ConfigurationImpl(){
		this.cm = new ComptabilitManagerImpl();
		this.selectedParts = new HashSet<>();
	}
	@Override
	public boolean isValid() {
	for(PartType part : selectedParts) {
		Set<PartType> incompatibilities = cm.getIncompatibilities(part);
		for(PartType IncPart : incompatibilities) {
		if (selectedParts.contains(IncPart)) return false;
		}
	}
		return true;
	}

	@Override
	public boolean isComplete() {
		boolean engineCpt = false, interCpt =false, exterCpt=false,tranCpt=false;
		for(PartType part : selectedParts) {
			if(part.getCategory().getName().equals("Interior")) interCpt = true;
			if(part.getCategory().getName().equals("Engine"))  engineCpt = true;
			if(part.getCategory().getName().equals("Exterior"))  exterCpt = true;
			if(part.getCategory().getName().equals("Transmission"))  tranCpt = true;
		}
		return interCpt && engineCpt && interCpt && tranCpt;
	}

	@Override
	public Set<PartType> getSelectedParts() {
		return Collections.unmodifiableSet(this.selectedParts);
	}

	@Override
	public void selectPart(PartType chosenPart) {
		selectedParts.add(chosenPart);
		}

	@Override
	public PartType getSelectionForCategory(Category category) {
		for(PartType part : this.selectedParts) {
			if((part.getCategory().getName()).equals(category.getName())) return part;
		}
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
		for(PartType part : this.selectedParts) {
			if((part.getCategory().getName()).equals(categoryToClear.getName())) selectedParts.remove(part);
		}
		
	}

	@Override
	public void clear() {
		this.selectedParts.removeAll(this.selectedParts);
	
	}

}
