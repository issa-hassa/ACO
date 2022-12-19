package fr.istic.nplouzeau.cartaylor.api;

public interface Part extends PropertyManager {
    /**
     * Get name the of the Part
     * @return the name of the class
     */
    default String getName() {
        return this.getClass().getTypeName();
    }

    /**
     * Get category of the part
     * @return the category
     */
    Category getCategory();

    /**
     * Get partType
     * @return the partType
     */
    PartType getType();

    void accept(PrintHtml p);

}
