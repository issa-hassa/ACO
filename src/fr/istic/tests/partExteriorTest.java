package fr.istic.tests;

import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;

public class partExteriorTest {


    @Test
    public void init(){

        Category exterior = new CategoryImpl("Exterior");
        PartType xc = new PartTypeImpl("XC", Exterior.XC.class,exterior);
        PartType xm = new PartTypeImpl("XM",Exterior.XM.class,exterior);
        PartType xs = new PartTypeImpl("XS",Exterior.XS.class,exterior);

             
    }
}
