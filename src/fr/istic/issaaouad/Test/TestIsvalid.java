package fr.istic.issaaouad.Test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istis.issaaouad.impl.CategoryImpl;
import fr.istis.issaaouad.impl.ComptabilitManagerImpl;
import fr.istis.issaaouad.impl.ConfigurationImpl;
import fr.istis.issaaouad.impl.PartTypeImpl;


public class TestIsvalid {
	
	ComptabilitManagerImpl cm = new ComptabilitManagerImpl();
	CategoryImpl engine = new CategoryImpl("Engine");
	CategoryImpl transmission = new CategoryImpl("Transmission");
	CategoryImpl exterior = new CategoryImpl("Exterior");
	CategoryImpl interior = new CategoryImpl("Interior");
	PartType p = new PartTypeImpl("EG100", engine);
	PartType p1 = new PartTypeImpl("EG133", engine);
	PartType p2 = new PartTypeImpl("EG210", engine);
	PartType p3 = new PartTypeImpl("ED110", engine);
	PartType p4 = new PartTypeImpl("ED180", engine);
	PartType p5 = new PartTypeImpl("EH120", engine);
	PartType p6 = new PartTypeImpl("TM5", transmission);
	PartType p7 = new PartTypeImpl("TM6", transmission);
	PartType p8 = new PartTypeImpl("TA5", transmission);
	PartType p9 = new PartTypeImpl("TS6", transmission);
	PartType p10 = new PartTypeImpl("TSF7", transmission);
	PartType p11= new PartTypeImpl("TC120", transmission);
	
	PartType p12 = new PartTypeImpl("XC", exterior);
	PartType p13 = new PartTypeImpl("XM", exterior);
	PartType p14 = new PartTypeImpl("XS", exterior);
	
	
	PartType p15 = new PartTypeImpl("IN", interior);
	PartType p16 = new PartTypeImpl("IH", interior);
	PartType p17= new PartTypeImpl("IS", interior);
	
	
	

		@Test
		void test1() {
			
		
		}
}
