package fr.istic.issaouad.impl;

import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.*;

import java.util.*;

public class ConfiguratorImpl implements Configurator {

    private ComptabilityManagerImpl cm;

    private HashSet<PartType> allPart;
    private Set<Category> categories;

    private Configuration configuration;




    CategoryImpl engine = new CategoryImpl(Utils.ENGINE);
    CategoryImpl exterior = new CategoryImpl(Utils.EXTERIOR);
    CategoryImpl interior = new CategoryImpl(Utils.INTERIOR);
    CategoryImpl transmission = new CategoryImpl(Utils.TRANSMISSION);

    public ConfiguratorImpl(){
        this.cm = new ComptabilityManagerImpl();
        this.categories  = new HashSet<>(Arrays.asList(engine,exterior,interior,transmission));
        this.allPart = new HashSet<>();

        init();
        this.configuration = new ConfigurationImpl(this.cm,new HashSet<>());

    }

    private void init(){
        PartType eg100 = new PartTypeImpl("EG100",Engine.EG100.class,engine);
        PartType eg133 = new PartTypeImpl("EG133",Engine.EG133.class,engine);
        PartType eg210 = new PartTypeImpl("EG210",Engine.EG210.class,engine);
        PartType ed110 = new PartTypeImpl("ED110",Engine.ED110.class,engine);
        PartType ed180 = new PartTypeImpl("ED180",Engine.ED180.class,engine);
        PartType eh120 = new PartTypeImpl("EH120",Engine.EH120.class,engine);

        allPart.addAll(Arrays.asList(eg100,eg133,eg210,eh120,ed110,ed180,eh120));

        PartType tm5 = new PartTypeImpl("TM5",Transmission.TM5.class,transmission);
        PartType tm6 = new PartTypeImpl("TM6",Transmission.TM6.class,transmission);
        PartType ta5 = new PartTypeImpl("TA5",Transmission.TA5.class,transmission);
        PartType ts6 = new PartTypeImpl("TS6",Transmission.TS6.class,transmission);
        PartType tsf7 = new PartTypeImpl("TSF7",Transmission.TSF7.class,transmission);
        PartType tc120 = new PartTypeImpl("TC120",Transmission.TC120.class,transmission);

        allPart.addAll(Arrays.asList(tm5,tm6,ta5,ts6,tsf7,tc120));

        cm.addIncompatibilities(ta5, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(tsf7, new HashSet<>(Arrays.asList(eg100,eg133,ed110)));
        cm.addRequirements(tc120,new HashSet<>(Arrays.asList(eh120)));

        PartType xc = new PartTypeImpl("XC",Exterior.XC.class,exterior);
        PartType xm = new PartTypeImpl("XM",Exterior.XM.class,exterior);
        PartType xs = new PartTypeImpl("XS",Exterior.XS.class,exterior);

        allPart.addAll(Arrays.asList(xc,xm,xs));

        cm.addIncompatibilities(xc, new HashSet<>(Arrays.asList(eg210)));
        cm.addIncompatibilities(xm, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(xs, new HashSet<>(Arrays.asList(eg100)));


        PartType in = new PartTypeImpl("IN",Interior.IN.class,interior);
        PartType ih = new PartTypeImpl("IH",Interior.IH.class,interior);
        PartType is = new PartTypeImpl("IS",Interior.IS.class,interior);

        allPart.addAll(Arrays.asList(in,ih,is));

        cm.addIncompatibilities(is, new HashSet<>(Arrays.asList(eg100,tm5)));
        cm.addRequirements(is,new HashSet<>(Arrays.asList(xs)));

        cm.addRequirements(xs,new HashSet<>(Arrays.asList(is)));
    }




    @Override
    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(this.categories);
    }

    @Override
    public Set<PartType> getVariants(Category category) {
        Objects.requireNonNull(category, "The category can't be null for getVariants");
        Set<PartType> variants = new HashSet<>();
        for(PartType p : allPart){
            if(p.getCategory().equals( category)){
                variants.add(p);
            }
        }
        return variants;
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }

    @Override
    public CompatibilityChecker getCompatibilityChecker() {
        return this.cm;
    }
}
