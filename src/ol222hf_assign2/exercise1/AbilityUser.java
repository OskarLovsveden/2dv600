/**
 * AbilityUser.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

import java.util.HashSet;
import java.util.Set;

/** AbilityUser extends Character. */
public abstract class AbilityUser extends Character {
    private Set<Ability> abilities = new HashSet<>();
    private Set<Proficiency> proficiencies;

    /**
     * Class constructor for an ability user.
     * 
     * @param name          the name of the ability user.
     * @param level         the level of the ability user.
     * @param className     the classname of the ability user.
     * @param attributes    the attributes for the ability user.
     * @param proficiencies the proficiencies of the ability user.
     */
    public AbilityUser(String name, int level, ClassName className, Attributes attributes,
            Set<Proficiency> proficiencies) {
        super(name, level, className, attributes);
        this.proficiencies = proficiencies;
    }

    /**
     * Lets an ability user learn a new ability, unless it is already known.
     * 
     * @param ability the ability to be learned.
     * @throws IllegalArgumentException when the ability user's and the ability's
     *                                  proficiencies does not match.
     */
    public void learnAbility(Ability ability) throws IllegalArgumentException {
        if (proficiencies.contains(ability.getProficiency())) {
            abilities.add(ability);
        } else {
            throw new IllegalArgumentException(ability + " with proficiency " + ability.getProficiency()
                    + " is an invalid ability for this character.");
        }
    }

    /**
     * Gets all known abilities.
     * 
     * @return a set of the known abilities.
     */
    public Set<Ability> getKnownAbilities() {
        return Set.copyOf(abilities);
    }
}
