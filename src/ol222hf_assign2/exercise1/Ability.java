/**
 * Ability.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Enum that lists available abilities and their proficiency. */
public enum Ability {
    DODGE("Dodge", Proficiency.ACROBATICS),
    EVASION("Evasion", Proficiency.ACROBATICS),
    CHARGE("Charge", Proficiency.ATHLETICS),
    LEAP("Leap", Proficiency.ATHLETICS),
    PICKPOCKET("Pickpocket", Proficiency.STEALTH),
    SNEAK_ATTACK("Sneak Attack", Proficiency.STEALTH),
    BONFIRE("Bonfire", Proficiency.SURVIVAL),
    FORAGE("Forage", Proficiency.SURVIVAL);

    private String name;
    private Proficiency proficiency;

    /**
     * Class constructor for the enum type Ability.
     * 
     * @param name        the name of the ability.
     * @param proficiency a proficiency that is connected to the ability.
     */
    private Ability(String name, Proficiency proficiency) {
        this.name = name;
        this.proficiency = proficiency;
    }

    public String getName() {
        return name;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }
}
