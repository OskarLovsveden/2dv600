/**
 * Rogue.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.Set;

/** Rogue extends AbilityUser. */
public class Rogue extends AbilityUser {

    /**
     * Rogue constructor that takes arguments for name and level.
     * 
     * @param name the rogue's name.
     * @param level the rogue's level.
     */
    public Rogue (String name, int level) {
        super(
            name,
            level,
            ClassName.ROGUE,
            new Attributes(),
            Set.<Proficiency>of(Proficiency.ACROBATICS, Proficiency.STEALTH)
        );
    }
    
    /**
     * Rogue constructor that takes arguments for name, level and attributes.
     * 
     * @param name the rogue's name.
     * @param level the rogue's level.
     * @param attributes the rogue's attributes.
     */
    public Rogue (String name, int level, Attributes attributes) {
        super(
            name,
            level,
            ClassName.ROGUE,
            attributes,
            Set.<Proficiency>of(Proficiency.ACROBATICS, Proficiency.STEALTH)
        );
    }
}
