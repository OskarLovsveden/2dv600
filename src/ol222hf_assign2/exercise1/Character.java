/**
 * Character.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

public abstract class Character {
    private String name;
    private int level;
    private ClassName className;
    private Attributes attributes;

    /**
     * Character constructor that takes arguments for name, level, classname and
     * attributes.
     * 
     * @param name       the character's name.
     * @param level      the character's level.
     * @param className  the character's classname.
     * @param attributes the character's attributes.
     */
    public Character(String name, int level, ClassName className, Attributes attributes) {
        this.name = name;
        this.level = level;
        this.className = className;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public ClassName getClassName() {
        return className;
    }

    /** Gets primary attribute value. */
    public int getPrimaryAttribute() {
        return attributes.getPrimaryAttributeValueOf(className);
    }

    /** Gets primary attribute name. */
    public String getPrimaryAttributeName() {
        return attributes.getPrimaryAttributeNameOf(className);
    }

    public String toString() {
        return "name: " + name + ", level: " + level + ", primary attribute: " + getPrimaryAttributeName() + " "
                + getPrimaryAttribute();
    }
}
