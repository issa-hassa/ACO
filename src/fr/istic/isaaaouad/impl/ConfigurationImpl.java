package fr.istic.isaaaouad.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.PartType;

public class ConfigurationImpl implements Configuration {
	ComptablityManagerImpl cm ;
	Set<PartType> selectedPartype;
	public ConfigurationImpl(ComptablityManagerImpl cm,Set<PartType> selectedPartype) {
		this.cm = cm;
		this.selectedPartype = selectedPartype;
	}
	@Override
	public boolean isValid() {
		
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
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
		this.cm = new ComptablityManagerImpl(new HashMap<PartType,Set<PartType>>(), 
					new HashMap<PartType,Set<PartType>>());
		
		this.selectedPartype.removeAll(selectedPartype);
	}

}
