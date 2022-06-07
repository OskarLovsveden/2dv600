/**
 * Attributes.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Attributes {
    private Attribute strength;
    private Attribute agility;
    private Attribute intelligence;
    private Attribute wisdom;

    /** Default class constructor, leads to random attributes with a sum of 20. */
    public Attributes() {
        Integer[] points = { 2, 4, 6, 8 };
        List<Integer> pointsList = Arrays.asList(points);
        Collections.shuffle(pointsList);
        pointsList.toArray(points);

        this.strength = new Attribute(AttributeName.STRENGTH, points[0]);
        this.agility = new Attribute(AttributeName.AGILITY, points[1]);
        this.intelligence = new Attribute(AttributeName.INTELLIGENCE, points[2]);
        this.wisdom = new Attribute(AttributeName.WISDOM, points[3]);
    }

    /**
     * Class constructor, that takes arguments for all attributes.
     * 
     * @param strength     the value of the strength attribute.
     * @param agility      the value of the agility attribute.
     * @param intelligence the value of the intelligence attribute.
     * @param wisdom       the value of the wisdom attribute.
     * @throws IllegalArgumentException if the sum of all attributes is > 20.
     */
    public Attributes(int strength, int agility, int intelligence, int wisdom) throws IllegalArgumentException {
        int total = strength + agility + intelligence + wisdom;

        if (total > 20) {
            throw new IllegalArgumentException(
                    "The combined sum of the attributes can not be more than 20. Total sum was: " + total);
        }

        this.strength = new Attribute(AttributeName.STRENGTH, strength);
        this.agility = new Attribute(AttributeName.AGILITY, agility);
        this.intelligence = new Attribute(AttributeName.INTELLIGENCE, intelligence);
        this.wisdom = new Attribute(AttributeName.WISDOM, wisdom);
    }

    public int getStrength() {
        return strength.getValue();
    }

    public int getAgility() {
        return agility.getValue();
    }

    public int getIntelligence() {
        return intelligence.getValue();
    }

    public int getWisdom() {
        return wisdom.getValue();
    }

    /**
     * Get the primary attribute of the className.
     * 
     * @param className the classname to look for a primary attribute of.
     * @return the matching attibute between the available attributes and the
     *         classname's primary attribute.
     * @throws NoSuchElementException if the attribute could not be found in the
     *                                existing attributes.
     */
    public Attribute getPrimaryAttribute(ClassName className) throws NoSuchElementException {
        Set<Attribute> attributes = Set.<Attribute>of(
                this.strength,
                this.agility,
                this.intelligence,
                this.wisdom);

        for (Attribute attribute : attributes) {
            if (attribute.getAttributeName() == className.getPrimaryAttribute()) {
                return attribute;
            }
        }

        throw new NoSuchElementException(className + " has no primary attribute.");
    }

    /**
     * Gets the primary attribute value.
     * 
     * @param className the classname to find the primary attribute value of.
     * @return an int representing the the value.
     */
    public int getPrimaryAttributeValueOf(ClassName className) {
        return getPrimaryAttribute(className).getValue();
    }

    /**
     * Gets the primary attribute name.
     * 
     * @param className the classname to find the primary attribute name of.
     * @return a String representing the the name.
     */
    public String getPrimaryAttributeNameOf(ClassName className) {
        return getPrimaryAttribute(className).getAttributeName().toString();
    }
}
