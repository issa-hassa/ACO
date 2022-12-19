package fr.istic.nplouzeau.cartaylor.api;

import fr.istic.issaouad.impl.PartImpl;

public interface PartType {

    String getName();

    Category getCategory();

    PartImpl newInstance();
    void accept(PrintHtml p);
}
