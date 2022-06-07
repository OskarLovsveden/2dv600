/**
 * AttributeName.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Enum that lists available attributenames and their name in String form. */
public enum AttributeName {
    STRENGTH("strength"),
    AGILITY("agility"),
    INTELLIGENCE("intelligence"),
    WISDOM("wisdom");

    private String name;

    /**
     * Class constructor for the AttributeName enum type.
     * 
     * @param name the name / text representation of the attribute name.
     */
    AttributeName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
