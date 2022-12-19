package fr.istic.tests;

import fr.istic.Utils;
import fr.istic.issaouad.impl.CategoryImpl;
import fr.istic.issaouad.impl.Engine;
import fr.istic.issaouad.impl.PartImpl;
import fr.istic.issaouad.impl.PartTypeImpl;
import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartTestEngine {


    @Test
    public void propertiesTest(){
        Category engine  = new CategoryImpl("Engine");
        PartType eg100 = new PartTypeImpl("EG100", Engine.EG100.class,engine);
        PartType eg133 = new PartTypeImpl("EG133",Engine.EG133.class,engine);
        PartType eg210 = new PartTypeImpl("EG210",Engine.EG210.class,engine);
        PartType ed110 = new PartTypeImpl("ED110",Engine.ED110.class,engine);
        PartType ed180 = new PartTypeImpl("ED180",Engine.ED180.class,engine);
        PartType eh120 = new PartTypeImpl("EH120",Engine.EH120.class,engine);

        PartImpl eg100Instance = eg100.newInstance();
        PartImpl eg133Instance = eg133.newInstance();
        PartImpl eg210Instance = eg210.newInstance();
        PartImpl ed110Instance = ed110.newInstance();
        PartImpl ed180Instance = ed180.newInstance();
        PartImpl eh120Instance = eh120.newInstance();

        assertEquals(eg100Instance.getProperty(Utils.POWER).get(), Utils.KW_100);
        assertEquals(eg133Instance.getProperty(Utils.POWER).get(), Utils.KW_133);
        assertEquals(eg210Instance.getProperty(Utils.POWER).get(), Utils.KW_210);
        assertEquals(ed110Instance.getProperty(Utils.POWER).get(), Utils.KW_110);
        assertEquals(ed180Instance.getProperty(Utils.POWER).get(), Utils.KW_180);
        assertEquals(eh120Instance.getProperty(Utils.POWER).get(), Utils.KW_120);

    }
}
