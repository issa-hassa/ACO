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
        PartType eg100 = new PartTypeImpl("EG100",engine);
        PartType eg133 = new PartTypeImpl("EG133",engine);
        PartType eg210 = new PartTypeImpl("EG210",engine);
        PartType ed110 = new PartTypeImpl("ED110",engine);
        PartType ed180 = new PartTypeImpl("ED180",engine);
        PartType eh120 = new PartTypeImpl("EH120",engine);

        allPart.addAll(Arrays.asList(eg100,eg133,eg210,eh120,ed110,ed180,eh120));

        PartType tm5 = new PartTypeImpl("TM5",transmission);
        PartType tm6 = new PartTypeImpl("TM6",transmission);
        PartType ta5 = new PartTypeImpl("TA5",transmission);
        PartType ts6 = new PartTypeImpl("TS6",transmission);
        PartType tsf7 = new PartTypeImpl("TSF7",transmission);
        PartType tc120 = new PartTypeImpl("TC120",transmission);

        allPart.addAll(Arrays.asList(tm5,tm6,ta5,ts6,tsf7,tc120));

        cm.addIncompatibilities(ta5, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(tsf7, new HashSet<>(Arrays.asList(eg100,eg133,ed110)));
        cm.addRequirements(tc120,new HashSet<>(Arrays.asList(eh120)));

        PartType xc = new PartTypeImpl("XC",exterior);
        PartType xm = new PartTypeImpl("XM",exterior);
        PartType xs = new PartTypeImpl("XS",exterior);

        allPart.addAll(Arrays.asList(xc,xm,xs));

        cm.addIncompatibilities(xc, new HashSet<>(Arrays.asList(eg210)));
        cm.addIncompatibilities(xm, new HashSet<>(Arrays.asList(eg100)));
        cm.addIncompatibilities(xs, new HashSet<>(Arrays.asList(eg100)));


        PartType in = new PartTypeImpl("IN",interior);
        PartType ih = new PartTypeImpl("IH",interior);
        PartType is = new PartTypeImpl("IS",interior);

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
