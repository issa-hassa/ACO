package fr.istic.tests;

import fr.istic.Utils;
import fr.istic.issaouad.impl.*;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartTestTransmission {

        @Test
        public void init(){
    CategoryImpl transmission = new CategoryImpl("Transmission");
    PartType tm5 = new PartTypeImpl("TM5", Transmission.TM5.class,transmission);
    PartType tm6 = new PartTypeImpl("TM6",Transmission.TM6.class,transmission);
    PartType ta5 = new PartTypeImpl("TA5",Transmission.TA5.class,transmission);
    PartType ts6 = new PartTypeImpl("TS6",Transmission.TS6.class,transmission);
    PartType tsf7 = new PartTypeImpl("TSF7",Transmission.TSF7.class,transmission);
    PartType tc120 = new PartTypeImpl("TC120",Transmission.TC120.class,transmission);

            PartImpl tm5Instance = tm5.newInstance();
            PartImpl tm6Instance = tm6.newInstance();
            PartImpl ta5Instance = ta5.newInstance();
            PartImpl ts6Instance = ts6.newInstance();
            PartImpl tsf7Instance = tsf7.newInstance();

            assertEquals(tm5Instance.getProperty(Utils.TRANSMISSION_SPEED).get(), Utils.G_5);
            assertEquals(tm6Instance.getProperty(Utils.TRANSMISSION_SPEED).get(), Utils.G_6);
            assertEquals(ta5Instance.getProperty(Utils.TRANSMISSION_SPEED).get(), Utils.G_5);
            assertEquals(ts6Instance.getProperty(Utils.TRANSMISSION_SPEED).get(), Utils.G_6);
            assertEquals(tsf7Instance.getProperty(Utils.TRANSMISSION_SPEED).get(), Utils.G_7);


}
}
