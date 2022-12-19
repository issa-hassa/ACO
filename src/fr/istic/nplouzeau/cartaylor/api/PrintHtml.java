package fr.istic.nplouzeau.cartaylor.api;

public interface PrintHtml {

    void visitCategory(Category c);
    void visitPart(Part p);
    void visitConfiguration(Configuration c);
    void visitPartType(PartType p);

}
