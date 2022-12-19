package fr.istic.tests;

import fr.istic.Utils;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class configuratorTest {

    Configurator config = new ConfiguratorImpl();

        CategoryImpl engine = new CategoryImpl(Utils.ENGINE);
        CategoryImpl exterior = new CategoryImpl(Utils.EXTERIOR);
        CategoryImpl interior = new CategoryImpl(Utils.INTERIOR);
        CategoryImpl transmission = new CategoryImpl(Utils.TRANSMISSION);


        PartType eg100 = new PartTypeImpl("EG100", engine);
        PartType eg133 = new PartTypeImpl("EG133", engine);
        PartType eg210 = new PartTypeImpl("EG210", engine);
        PartType ed110 = new PartTypeImpl("ED110", engine);
        PartType ed180 = new PartTypeImpl("ED180", engine);
        PartType eh120 = new PartTypeImpl("EH120", engine);

    PartType tm5 = new PartTypeImpl("TM5",transmission);
    PartType tm6 = new PartTypeImpl("TM6",transmission);
    PartType ta5 = new PartTypeImpl("TA5",transmission);
    PartType ts6 = new PartTypeImpl("TS6",transmission);
    PartType tsf7 = new PartTypeImpl("TSF7",transmission);
    PartType tc120 = new PartTypeImpl("TC120",transmission);

    PartType xc = new PartTypeImpl("XC",exterior);
    PartType xm = new PartTypeImpl("XM",exterior);
    PartType xs = new PartTypeImpl("XS",exterior);

    PartType in = new PartTypeImpl("IN",interior);
    PartType ih = new PartTypeImpl("IH",interior);
    PartType is = new PartTypeImpl("IS",interior);

/*
 *@Return a set of PartType that is contained in the set that getVariants returns
 */

public Set<PartType> ReturnPart(Set<PartType> pt, Category cat ) {
    Set<PartType> result = new HashSet<>();
    for (PartType p : config.getVariants(cat)) {
        for (PartType p1 : pt) {
            if (((PartTypeImpl) p1).equals(p)) result.add(p);
        }
    }
    return result;
}


    @Test
    @DisplayName("test de getVariants Engine")
    public void getVariantTest1() {
     //check when the categorie is null
     assertEquals(ReturnPart(new HashSet<>(Arrays.asList(eg100,eg133,eg210,eh120,ed110,ed180,eh120)), engine), config.getVariants(engine));
    }




    @Test
    @DisplayName("test de getVariants Transmission")
    public void getVariantTest2() {
        assertEquals(ReturnPart(new HashSet<>(Arrays.asList(tm5,tm6,ta5,ts6,tsf7,tc120)), transmission), config.getVariants(transmission));
    }


    @Test
    @DisplayName("test de getVariants exterior")
    public void getVariantTest3() {
        assertEquals(ReturnPart(new HashSet<>(Arrays.asList(xc,xm,xs)), exterior), config.getVariants(exterior));
    }

    @Test
    @DisplayName("test de getVariants interior")
    public void getVariantTest4() {
        assertEquals(ReturnPart(new HashSet<>(Arrays.asList(in,ih,is)), interior), config.getVariants(interior));
    }
}
