package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

public class PrintHtmlImpl implements PrintHtml {

    PrintStream out;

    public PrintHtmlImpl(PrintStream out) {
        this.out = out;
    }

    @Override
    public void visitCategory(Category c) {

        out.println("Categorie : " +c.getName());


    }

    @Override
    public void visitPart(Part p) {

        out.println("<h2>");
        out.println(p.getName());
        out.println("</h2>");

        out.println("<h3>");
        this.visitCategory(p.getCategory());
        out.println("</h3>");
        out.println("<ul>");
        for(String pr : p.getPropertyNames()){
            out.println("<li>");
            out.print(p +" : " );
            if(p.getProperty(pr).isPresent()){
                out.print(p.getProperty(pr).get());
            }
            out.println("</li>");
        }
        out.println("</ul>");



    }

    @Override
    public void visitConfiguration(Configuration c) {
        out.println("<h1> Configuration :  </h1>" );
        for(PartType p : c.getSelectedParts())  p.accept(this);

    }

    @Override
    public void visitPartType(PartType p) {
            Part part = ((PartTypeImpl)p).part;
            part.accept(this);
            //out.println(p.getName());
    }
}
