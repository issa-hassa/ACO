package fr.istic.tests;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import fr.istic.Utils;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.Configurator;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class ConfigurationTest {

    private  Configurator configurator;
    private  Configuration configuration;

     Set<PartType> engines;
     Set<PartType> interiors;
     Set<PartType> exteriors;
     Set<PartType> transmissions;



    @Before
    public  void  init(){
        configurator = new ConfiguratorImpl();
        configuration = configurator.getConfiguration();
        engines =  (configurator.getVariants(new CategoryImpl(Utils.ENGINE)));
        interiors =  (configurator.getVariants( new CategoryImpl(Utils.INTERIOR)));
        exteriors =  (configurator.getVariants( new CategoryImpl(Utils.EXTERIOR)));
        transmissions =  (configurator.getVariants( new CategoryImpl(Utils.TRANSMISSION)));

    }

    @AfterEach
    public void clear() {
        configuration.clear();
    }


    @Test
    public void isComplete(){
        assertFalse(configuration.isComplete());
        configuration.selectPart(engines.iterator().next());
        assertFalse(configuration.isComplete());
        configuration.selectPart(interiors.iterator().next());
        assertFalse(configuration.isComplete());
        configuration.selectPart(exteriors.iterator().next());
        assertFalse(configuration.isComplete());
        configuration.selectPart(transmissions.iterator().next());
        assertTrue(configuration.isComplete());
        configuration.selectPart(transmissions.iterator().next());
        assertTrue(configuration.isComplete());
        configuration.clear();

    }

    @Test
    /**
     * test pour (xs --> is, TC120 --> EH120)
     */
    public void isValid1(){

        for(PartType t : transmissions){
            if(t.getName().equals("TC120")  ){
                configuration.selectPart(t);
            }
        }
        for(PartType e : engines){
            if(e.getName().equals("EH120")){
                configuration.selectPart(e);
            }
        }
        for(PartType x : exteriors){
            if(x.getName().equals("XS")){
                configuration.selectPart(x);
            }
        }
        for(PartType i : interiors){
            if(i.getName().equals("IS")){
                configuration.selectPart(i);
            }
        }

        assertTrue(configuration.isValid());
        configuration.clear();


    }
    @Test
    public void isValid2(){
        for(PartType t : transmissions){
            if(t.getName().equals("TA5")){
                configuration.selectPart(t);
                assertTrue(configuration.isValid());
            }
        }
        for(PartType e : engines){
            if(e.getName().equals("EG100")){
                configuration.selectPart(e);
                assertFalse(configuration.isValid());
            }
        }
        configuration.clear();

        for(PartType t : transmissions){
            if(t.getName().equals("TSF7")){
                configuration.selectPart(t);
                assertTrue(configuration.isValid());
            }
        }
        for(PartType e : engines){
            if(e.getName().equals("EG100")||e.getName().equals("EG133")||e.getName().equals("ED110")){
                configuration.selectPart(e);
                assertFalse(configuration.isValid());
            }
        }



    }
}
