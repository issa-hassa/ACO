package fr.istic.tests;

import fr.istic.isaaaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Before;

import java.util.Set;

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


    Set<PartType> listIncomp ;
    Set<PartType> listIncomp1;
    Set<PartType> listReq;

    @Before
    public void init(){
         eg100 = new PartTypeImpl("EG100",new Engine()) ;
         eg133 = new PartTypeImpl("EG133",new Engine());
         eg210 = new PartTypeImpl("EG210",new Engine()) ;
         ed110 = new PartTypeImpl("EG110",new Engine()) ;
         ed180 = new PartTypeImpl("EG180",new Engine()) ;
         eh120 = new PartTypeImpl("EG120",new Engine()) ;

         xc = new PartTypeImpl("XC",new Exterior());
         xm = new PartTypeImpl("XM",new Exterior());
         xs = new PartTypeImpl("XS",new Exterior());

         in = new PartTypeImpl("IN",new Interior());
         ih = new PartTypeImpl("IH",new Interior());
         is = new PartTypeImpl("IS",new Interior());

         tm5 = new PartTypeImpl("TM5",new Transmission());
         tm6 = new PartTypeImpl("TM5",new Transmission());
         ta5 = new PartTypeImpl("TM5",new Transmission());
         ts6 = new PartTypeImpl("TM5",new Transmission());
         tsf7 = new PartTypeImpl("TM5",new Transmission());
         tc120 = new PartTypeImpl("TM5",new Transmission());









    }







}
