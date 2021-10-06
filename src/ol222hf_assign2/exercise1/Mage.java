/**
 * Mage.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.Set;

/** Mage extends Spellcaster. */
public class Mage extends SpellCaster {

    /**
     * Mage constructor that takes arguments for name and level.
     * 
     * @param name The mage's name.
     * @param level The mage's level.
     */
    public Mage (String name, int level) {
        super(
            name,
            level,
            ClassName.MAGE,
            new Attributes(),
            Set.<School>of(School.EVOCATION, School.ALTERATION)
        );
    }
    
    /**
     * Mage constructor that takes arguments for name, level and attributes.
     * 
     * @param name the mage's name.
     * @param level the mage's level.
     * @param attributes the mage's attributes.
     */
    public Mage (String name, int level, Attributes attributes) {
        super(
            name,
            level,
            ClassName.MAGE,
            attributes,
            Set.<School>of(School.EVOCATION, School.ALTERATION)
        );
    }
}
