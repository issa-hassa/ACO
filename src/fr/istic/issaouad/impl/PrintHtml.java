package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.*;

import java.io.PrintStream;

public class PrintHtml implements Visitor {

    PrintStream out;
    Configuration conf;
    public PrintHtml(PrintStream out, Configuration config) {
        this.out = out;
        this.conf = config;
    }

    public void printConfiguration(){
        visitConfiguration(conf);

    }
    @Override
    public void visitCategory(Category c) {


        out.println("Categorie : " +c.getName());


    }
    private void printHead(){
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">");
        out.println("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>Projet ACO : CARS TAYLOR</title>\n" +
                "\n" +
                "</head>"
        );


    }


    @Override
    public void visitPart(Part p) {


        out.println("<h3>");
        this.visitCategory(p.getCategory());
        out.println("</h3>");
        out.println("<ul>");
        for(String pr : p.getPropertyNames()){
            out.println("<li>");
            out.print(pr +" : " );
            if(p.getProperty(pr).isPresent()){
                out.print(p.getProperty(pr).get());
            }

            out.println("</li>");
        }
        out.println("</ul>");



    }

    @Override
    public void visitConfiguration(Configuration c) {
        printHead();
        out.println("<body>");
        out.println("<h1> Configuration :  </h1>" );
        for(PartType p : c.getSelectedParts())  p.accept(this);
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void visitPartType(PartType p) {
            out.println("<h2>" +
                    p.getName()
                    +"</h2>"
            );

            Part part = ((PartTypeImpl)p).part;
            part.accept(this);
            //out.println(p.getName());
    }
}
