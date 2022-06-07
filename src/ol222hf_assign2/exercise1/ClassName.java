/**
 * ClassName.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Enum that lists available classnames and their primary attribute. */
public enum ClassName {
    MAGE(AttributeName.INTELLIGENCE),
    WARRIOR(AttributeName.STRENGTH),
    ROGUE(AttributeName.AGILITY),
    CLERIC(AttributeName.WISDOM);

    private AttributeName primaryAttribute;

    /**
     * Class constructor for the enum type ClassName.
     * 
     * @param primaryAttribute the primary attribute for the classname.
     */
    private ClassName(AttributeName primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public AttributeName getPrimaryAttribute() {
        return primaryAttribute;
    }
}
