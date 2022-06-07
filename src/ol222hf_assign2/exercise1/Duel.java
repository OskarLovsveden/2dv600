/**
 * Duel.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Duel extends Combat. */
public class Duel extends Combat {
    private Character duelist1;
    private Character duelist2;
    private Character winner;

    /**
     * Duel constructor that takes two characters.
     * 
     * @param duelist1 the first duelist, a character.
     * @param duelist2 the second duelist, a character.
     */
    public Duel(Character duelist1, Character duelist2) {
        super();
        this.duelist1 = duelist1;
        this.duelist2 = duelist2;
    }

    public Character getWinner() {
        return winner;
    }

    /**
     * Start the duel. A character/duelist wins by having higher level, higher
     * primary attribute or the most known spells/abilities.
     * If all three winconditions are equal between the two characters/duelists the
     * duel ends in a tie.
     */
    public void start() {
        boolean isOfSameLevel = isOfEqualStats(duelist1.getLevel(), duelist2.getLevel());
        boolean equalPrimaryAttribute = isOfEqualStats(duelist1.getPrimaryAttribute(), duelist2.getPrimaryAttribute());
        boolean sameNumOfKnownActions = isOfEqualStats(knownActions(duelist1), knownActions(duelist2));

        if (isOfSameLevel && equalPrimaryAttribute && sameNumOfKnownActions) {
            // Tie
            winner = null;
        } else if (isOfSameLevel && !equalPrimaryAttribute) {
            // Won on highest primary attribute
            winner = duelist1.getPrimaryAttribute() > duelist2.getPrimaryAttribute() ? duelist1 : duelist2;
        } else if (isOfSameLevel && equalPrimaryAttribute) {
            // Won on most known spells or abilities
            winner = knownActions(duelist1) > knownActions(duelist2) ? duelist1 : duelist2;
        } else {
            // Won on highest level
            winner = duelist1.getLevel() > duelist2.getLevel() ? duelist1 : duelist2;
        }
    }

    /**
     * Get the amount of known spells or abilities of a character/duelist.
     * 
     * @param character the character to check for amount of known spells/abilities.
     * @return the amount of spells/abilities.
     */
    private static int knownActions(Character character) {
        if (character instanceof SpellCaster) {
            SpellCaster sc = (SpellCaster) character;
            return sc.getKnownSpells().size();
        } else if (character instanceof AbilityUser) {
            AbilityUser au = (AbilityUser) character;
            return au.getKnownAbilities().size();
        }

        return 0;
    }
}
