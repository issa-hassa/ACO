package fr.istic.issaouad.impl;

import fr.istic.nplouzeau.cartaylor.api.Category;
import fr.istic.nplouzeau.cartaylor.api.Part;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import fr.istic.nplouzeau.cartaylor.api.PrintHtml;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PartImpl implements Part {
    private PartType type;


    public PartImpl(PartType type) {
        this.type = type;
    }


    /**
     * Get category of the part
     *
     * @return the category
     */
    @Override
    public Category getCategory() {
        return this.type.getCategory();
    }

    /**
     * Get partType
     *
     * @return the partType
     */
    @Override
    public PartType getType() {
        return type;
    }




    private class Property {
        /** Getter for property*/
        public final Supplier<String> getter;
        /** Setter for property*/
        public final Consumer<String> setter;
        /** Possible values for property*/
        public final Set<String> possibleValues;

        /**
         * Constructor for Property
         * @param getter, the getter for the property
         * @param setter, the setter for the property
         * @param possibleValues, available values for this property
         */
        Property(Supplier<String> getter, Consumer<String> setter, Set<String> possibleValues) {
            this.getter = getter;
            this.setter = setter;
            this.possibleValues = possibleValues;

        }



    }
    private final Map<String, Property> properties = new HashMap<>();


    /**
     * Add a property
     * @param name, name of the property
     * @param getter, getter method to get the property
     * @param setter, setter method to change the property
     * @param possibleValues, set of possible values
     */
    protected void addProperty(String name, Supplier<String> getter, Consumer<String> setter,
                               Set<String> possibleValues) {
        properties.put(name, new Property(getter, setter, possibleValues));
    }





    /**
     * Returns an immutable set of the property names supported by the property manager.
     *
     * @return the name of the properties
     */

    @Override
    public Set<String> getPropertyNames() {
        return Collections.unmodifiableSet(properties.keySet());
    }

    /**
     * Returns the immutable set of discrete string values for a given property.
     * For properties that have a non explicit set of possible values (eg double converted to strings),
     * or for a non existing property name, returns an empty set.
     *
     * @param propertyName a non-null string reference
     * @return an immutable set (see above)
     */

    @Override
    public Set<String> getAvailablePropertyValues(String propertyName) {
        if (properties.containsKey(propertyName)) {
            return Collections.unmodifiableSet(properties.get(propertyName).possibleValues);
        }
        return Collections.emptySet();
    }

    /**
     * Returns the optional value of a property.
     * If the object does not support that property then an empty optional is returned.
     *
     * @param propertyName the property to read
     * @return the property if available, else an empty optional
     */
    @Override
    public Optional<String> getProperty(String propertyName) {
        Objects.requireNonNull(propertyName);

        if (properties.containsKey(propertyName)) {
            return Optional.of(properties.get(propertyName).getter.get());
        }
        return Optional.empty();
    }

    /**
     * Sets the value of a given property.
     * If there is not such property, or if it not writable, or if the value is invalid
     * then an IllegalArgumentException is thrown.
     *
     * @param propertyName
     * @param propertyValue
     * @throws IllegalArgumentException (see above)
     */
    @Override
    public void setProperty(String propertyName, String propertyValue) {
        Objects.requireNonNull(propertyName);
        Objects.requireNonNull(propertyValue);

        if ((properties.containsKey(propertyName)) && (properties.get(propertyName).setter != null)) {
            properties.get(propertyName).setter.accept(propertyValue);
        } else {
            throw new IllegalArgumentException("bad property name or value: " + propertyName);
        }
    }

    @Override
    public void accept(PrintHtml p) {

    }
}
