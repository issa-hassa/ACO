package fr.istis.issaaouad.impl;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.*;

public class ConfigurationImpl implements Configuration{

	Set<PartType> selectedParts;
	Set <PartType> InselectedParts;
	CompatibilityManager cm;
	
	@Override
	public boolean isValid() {
	for(PartType part : selectedParts) {
		Set<PartType> incompatibilities = cm.getIncompatibilities(part);
		if (incompatibilities.contains(part)) return false;
	}
		return true;
	}

	@Override
	public boolean isComplete() {
		
		return false;
	}

	@Override
	public Set<PartType> getSelectedParts() {
		return selectedParts;
	}

	@Override
	public void selectPart(PartType chosenPart) {
		selectedParts.add(chosenPart);
		}

	@Override
	public PartType getSelectionForCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
