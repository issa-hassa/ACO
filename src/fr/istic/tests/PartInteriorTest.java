package fr.istic.tests;

import fr.istic.Utils;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PartInteriorTest{

        @Test
        public void init(){

            Category interior = new CategoryImpl("Interior");
            PartType in = new PartTypeImpl("IN",Interior.IN.class,interior);
            PartType ih = new PartTypeImpl("IH",Interior.IH.class,interior);
            PartType is = new PartTypeImpl("IS",Interior.IS.class,interior);

            PartImpl INInstance = in.newInstance();
            PartImpl IHInstance = ih.newInstance();
            PartImpl ISInstance = is.newInstance();

            assertEquals(INInstance.getProperty(Utils.QUALITY).get(), Utils.Quality.STANDARD.name());
            assertEquals(IHInstance.getProperty(Utils.QUALITY).get(), Utils.Quality.HIGH.name() );
            assertEquals(ISInstance.getProperty(Utils.QUALITY).get(), Utils.Quality.SPORT.name());
        }
    }

