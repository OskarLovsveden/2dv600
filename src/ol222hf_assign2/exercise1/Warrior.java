/**
 * Warrior.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.Set;

/** Warrior extends AbilityUser */
public class Warrior extends AbilityUser {

    /**
     * Warrior constructor that takes a name and a level.
     * 
     * @param name  the warrior's name.
     * @param level the warrior's level.
     */
    public Warrior(String name, int level) {
        super(
                name,
                level,
                ClassName.WARRIOR,
                new Attributes(),
                Set.<Proficiency>of(Proficiency.ATHLETICS, Proficiency.SURVIVAL));
    }

    /**
     * Warrior constructor that takes a name, level and attributes.
     * 
     * @param name       the warrior's name.
     * @param level      the warrior's level.
     * @param attributes the warrior's attributes.
     */
    public Warrior(String name, int level, Attributes attributes) {
        super(
                name,
                level,
                ClassName.WARRIOR,
                attributes,
                Set.<Proficiency>of(Proficiency.ATHLETICS, Proficiency.SURVIVAL));
    }
}
