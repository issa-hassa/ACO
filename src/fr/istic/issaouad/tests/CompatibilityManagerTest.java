package fr.istic.issaouad.tests;

import fr.istic.issaouad.impl.*;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.CompatibilityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompatibilityManagerTest {



    PartTypeImpl eg100 ;
    PartTypeImpl eg133 ;
    PartTypeImpl eg210 ;
    PartTypeImpl ed110 ;
    PartTypeImpl ed180 ;
    PartTypeImpl eh120 ;

    PartTypeImpl xc ;
    PartTypeImpl xm;
    PartTypeImpl xs;

    PartTypeImpl in;
    PartTypeImpl ih;
    PartTypeImpl is;


    PartTypeImpl tm5 ;
    PartTypeImpl tm6 ;
    PartTypeImpl ta5 ;
    PartTypeImpl ts6 ;
    PartTypeImpl tsf7 ;
    PartTypeImpl tc120 ;

    CategoryImpl engine = new Engine();
    CategoryImpl exterior = new Exterior();
    CategoryImpl interior = new Interior();
    CategoryImpl transmission = new Transmission();

   CompatibilityManager cm = new ComptabilityManagerImpl();

    @Before
    public void init(){
         eg100 = new PartTypeImpl("EG100",engine) ;
         eg133 = new PartTypeImpl("EG133",engine);
         eg210 = new PartTypeImpl("EG210",engine) ;
         ed110 = new PartTypeImpl("EG110",engine) ;
         ed180 = new PartTypeImpl("EG180",engine) ;
         eh120 = new PartTypeImpl("EG120",engine) ;

         xc = new PartTypeImpl("XC",exterior);
         xm = new PartTypeImpl("XM",exterior);
         xs = new PartTypeImpl("XS",exterior);

         in = new PartTypeImpl("IN",interior);
         ih = new PartTypeImpl("IH",interior);
         is = new PartTypeImpl("IS",interior);

         tm5 = new PartTypeImpl("TM5",transmission);
         tm6 = new PartTypeImpl("TM5",transmission);
         ta5 = new PartTypeImpl("TM5",transmission);
         ts6 = new PartTypeImpl("TM5",transmission);
         tsf7 = new PartTypeImpl("TM5",transmission);
         tc120 = new PartTypeImpl("TM5",transmission);

        cm.addRequirements(eh120,new HashSet<>(Arrays.asList(tc120)));
        cm.addIncompatibilities(xc, new HashSet<>(Arrays.asList(eg210)));
        cm.addIncompatibilities(xm, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(xs, new HashSet<>(Arrays.asList(eg100)));
        cm.addRequirements(xs,new HashSet<>(Arrays.asList(is)));

        cm.addRequirements(is,new HashSet<>(Arrays.asList(xs)));
        cm.addIncompatibilities(is, new HashSet<>(Arrays.asList(eg100,tm5)));

        cm.addIncompatibilities(ta5, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(tsf7, new HashSet<>(Arrays.asList(eg100,eg133,ed110)));
        cm.addRequirements(tc120,new HashSet<>(Arrays.asList(eh120)));


    }

    @DisplayName("test de : addRequirements()")
    @Test
    public void addRequirementsTest(){
        assertTrue(cm.getRequirements(eg100).isEmpty());
        assertTrue(cm.getRequirements(eg133).isEmpty());
        assertTrue(cm.getRequirements(eg210).isEmpty());
        assertTrue(cm.getRequirements(ed110).isEmpty());
        assertTrue(cm.getRequirements(ed180).isEmpty());
        assertEquals(1,cm.getRequirements(eh120).size() );
        assertTrue(cm.getRequirements(eh120).contains(tc120));
        assertTrue(cm.getRequirements(tm5).isEmpty());
        assertTrue(cm.getRequirements(tm6).isEmpty());
        assertTrue(cm.getRequirements(ta5).isEmpty());
        assertTrue(cm.getRequirements(ts6).isEmpty());
        assertTrue(cm.getRequirements(tsf7).isEmpty());

        assertTrue(cm.getRequirements(tc120).size() == 1
                && cm.getRequirements(tc120).contains(eh120));

        assertTrue(cm.getRequirements(xc).isEmpty());
        assertTrue(cm.getRequirements(xm).isEmpty());

        assertTrue(cm.getRequirements(xs).size() == 1
                && cm.getRequirements(xs).contains(is));

        assertTrue(cm.getRequirements(ed110).isEmpty());
        assertTrue(cm.getRequirements(ed180).isEmpty());



        assertTrue(cm.getRequirements(in).isEmpty());
        assertTrue(cm.getRequirements(ih).isEmpty());

        assertTrue(cm.getRequirements(is).size() == 1
                && cm.getRequirements(is).contains(xs));



    }








}
