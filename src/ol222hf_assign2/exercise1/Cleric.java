/**
 * Cleric.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.Set;

/** Cleric extends SpellCaster. */
public class Cleric extends SpellCaster {
    /**
     * Cleric constructor that takes name and a level.
     * 
     * @param name the name of the cleric.
     * @param level the level of the cleric.
     */
    public Cleric (String name, int level) {
        super(
            name,
            level,
            ClassName.CLERIC,
            new Attributes(),
            Set.<School>of(School.DIVINATION, School.RESTORATION)
        );
    }

    /**
     * Cleric constructor that takes name, level and attributes.
     * 
     * @param name the name of the cleric.
     * @param level the level of the cleric.
     * @param attributes the attributes of the cleric.
     */
    public Cleric (String name, int level, Attributes attributes) {
        super(
            name,
            level,
            ClassName.CLERIC,
            attributes,
            Set.<School>of(School.DIVINATION, School.RESTORATION)
        );
    }
}
