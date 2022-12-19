package fr.istic.tests;

import fr.istic.Utils;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;

import javax.swing.*;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class partExteriorTest {


    @Test
    public void init(){

        Category exterior = new CategoryImpl("Exterior");
        PartType xc = new PartTypeImpl("XC", Exterior.XC.class,exterior);
        PartType xm = new PartTypeImpl("XM",Exterior.XM.class,exterior);
        PartType xs = new PartTypeImpl("XS",Exterior.XS.class,exterior);

        PartImpl XCInstance = xc.newInstance();
        PartImpl XMInstance = xm.newInstance();
        PartImpl XSInstance = xs.newInstance();

        assertEquals(XCInstance.getProperty(Utils.PAINT), Optional.of(Utils.Color.CLASSIC.name()) );
        assertEquals(XMInstance.getProperty(Utils.PAINT), Optional.of(Utils.Color.METALLIC.name()) );
        assertEquals(XSInstance.getProperty(Utils.PAINT).get(), Utils.Color.RED.name() );
    }
}
