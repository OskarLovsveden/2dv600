/**
 * SpellCaster.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.HashSet;
import java.util.Set;

/** SpellCaster extends Character. */
public abstract class SpellCaster extends Character {
    private Set<Spell> spellBook = new HashSet<>();
    private Set<School> schools;

    /**
     * SpellCaster constructor that takes arguments for name, level, classname,
     * attributes and schools.
     * 
     * @param name       the spellcaster's name.
     * @param level      the spellcaster's level.
     * @param className  the spellcaster's classname.
     * @param attributes the spellcaster's attributes.
     * @param schools    the spellcaster's schools.
     */
    public SpellCaster(String name, int level, ClassName className, Attributes attributes, Set<School> schools) {
        super(name, level, className, attributes);
        this.schools = schools;
    }

    /**
     * Lets a spellcaster learn a new spell, unless it is already known.
     * 
     * @param spell the spell to be learned.
     * @throws IllegalArgumentException when the spellcaster's and the spell's
     *                                  schools does not match.
     */
    public void learnSpell(Spell spell) {
        if (schools.contains(spell.getSchool())) {
            spellBook.add(spell);
        } else {
            throw new IllegalArgumentException(
                    spell + " with school " + spell.getSchool() + " is an invalid spell for this character.");
        }
    }

    /**
     * Gets all known spells.
     * 
     * @return a set of the known spells.
     */
    public Set<Spell> getKnownSpells() {
        return Set.copyOf(spellBook);
    }
}
