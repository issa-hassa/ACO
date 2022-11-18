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
			if(part.getCategory() instanceof Interior) interCpt = true;
			if(part.getCategory() instanceof Engine) engineCpt = true;
			if(part.getCategory() instanceof Exterior) interCpt = true;
			if(part.getCategory() instanceof Transmission) tranCpt = true;
		}
		return interCpt && engineCpt && interCpt && tranCpt;
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
