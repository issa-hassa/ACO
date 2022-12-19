package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.omg.CORBA.Object;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartTypeImpl implements PartType {
	private String name;
	private Category category;

	private Class <? extends PartImpl> classRef;



	public PartTypeImpl(String name,Class <? extends PartImpl> classRef, Category category){
		Objects.requireNonNull(name, " the name of the part can't be null");
		Objects.requireNonNull(category, " the category of the part can't be null");
		this.name = name;
		this.category = category;
		this.classRef = classRef;

	}

	public PartImpl newInstance(){
		Constructor<? extends PartImpl> constructor;
		try {
			constructor = classRef.getConstructor();
			return constructor.newInstance();
		}
		catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,"constructor call failed ",e);
			System.exit(-1);
		}
		return null;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public Category getCategory() {
		return this.category;
	}




}
