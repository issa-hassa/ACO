package fr.istic.issaouad.impl;

import fr.istic.Utils;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.PrintHtml;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ConfiguratorImpl configurator = new ConfiguratorImpl();
        Configuration configuration = configurator.getConfiguration();
        configurator = new ConfiguratorImpl();
        configuration = configurator.getConfiguration();
        Set<PartType> engines =  (configurator.getVariants(new CategoryImpl(Utils.ENGINE)));
        Set<PartType>  interiors =  (configurator.getVariants( new CategoryImpl(Utils.INTERIOR)));
        Set<PartType> exteriors =  (configurator.getVariants( new CategoryImpl(Utils.EXTERIOR)));
        Set<PartType> transmissions =  (configurator.getVariants( new CategoryImpl(Utils.TRANSMISSION)));
        for(PartType p : engines){
            if(p.getName().equals("ED180")) configuration.selectPart(p);
        }
        for(PartType p : interiors){
            if(p.getName().equals("IN")) configuration.selectPart(p);
        }
        for(PartType p : exteriors){
            if(p.getName().equals("XS")) configuration.selectPart(p);
        }
        for(PartType p : exteriors){
            if(p.getName().equals("TM5")) configuration.selectPart(p);
        }
        System.out.println(configuration.getSelectedParts().size());
        PrintHtml html = new PrintHtmlImpl(System.out);
        html.visitConfiguration(configuration);

    }
}

