/**
 * Spell.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Enum that lists available spells. */
public enum Spell {
    MAGIC_MISSILE("Magic Missile", School.EVOCATION),
    FIRE_BOLT("Fire Bolt", School.EVOCATION),
    TELEKINESIS("Telekinesis", School.ALTERATION),
    PARALYZE("Paralyze", School.ALTERATION),
    MIND_SPIKE("Mind Spike", School.DIVINATION),
    TRUE_STRIKE("True Strike", School.DIVINATION),
    HEALING_HANDS("Healing Hands", School.RESTORATION),
    SUN_FIRE("Sun Fire", School.RESTORATION);

    private String name;
    private School school;

    /**
     * Spell constructor that takes an argument for name and school.
     * 
     * @param name   the spell's name.
     * @param school the spell's school.
     */
    private Spell(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public School getSchool() {
        return school;
    }
}
