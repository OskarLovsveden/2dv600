/**
 * Attribute.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

public class Attribute {
    private AttributeName attributeName;
    private int value;

    /**
     * Class constructor for an attribute.
     * 
     * @param attributeName the name of the attribute.
     * @param value the value of the attribute.
     */
    public Attribute(AttributeName attributeName, int value) {
        this.attributeName = attributeName;
        this.value = value;
    }

    public AttributeName getAttributeName() {
        return attributeName;
    }

    public int getValue() {
        return value;
    }
}
