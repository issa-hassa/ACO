package fr.istic.isaaaouad.impl;

import javax.lang.model.element.Parameterizable;

public class Main {
    public static void main(String[] args) {
        String nom = "part";
        PartTypeImpl p1 = new PartTypeImpl(nom,new Engine());
        PartTypeImpl p2 = new PartTypeImpl("gg",new Engine());

    }
}
