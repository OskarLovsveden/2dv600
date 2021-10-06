/**
 * Main.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Main class for "testing" the classes of assignment 2, exercise 1. */
public class Main {
    public static void main(String args[]) {
        // party1
        Mage mage1 = new Mage("mage1", 5, new Attributes(5, 5, 5, 5));
        mage1.learnSpell(Spell.MAGIC_MISSILE);

        Warrior warrior1 = new Warrior("warrior1", 5, new Attributes(5, 5, 5, 5));
        warrior1.learnAbility(Ability.LEAP);
        
        Rogue rogue1 = new Rogue("rogue1", 5, new Attributes(5, 5, 5, 5));
        rogue1.learnAbility(Ability.SNEAK_ATTACK);
        
        Cleric cleric1 = new Cleric("cleric1", 5, new Attributes(5, 5, 5, 5));
        cleric1.learnSpell(Spell.SUN_FIRE);
        
        Character[] party1 = { mage1, warrior1, rogue1, cleric1 };
        
        // party2
        Mage mage2 = new Mage("mage2", 5, new Attributes(5, 5, 5, 5));
        mage2.learnSpell(Spell.MAGIC_MISSILE);
        
        Warrior warrior2 = new Warrior("warrior2", 5, new Attributes(5, 5, 5, 5));
        warrior2.learnAbility(Ability.LEAP);
        
        Rogue rogue2 = new Rogue("rogue2", 5, new Attributes(5, 5, 5, 5));
        rogue2.learnAbility(Ability.SNEAK_ATTACK);
        
        Cleric cleric2 = new Cleric("cleric2", 5, new Attributes(5, 5, 5, 5));
        cleric2.learnSpell(Spell.SUN_FIRE);
        
        Character[] party2 = { mage2, warrior2, rogue2, cleric2 };

        // Print party stats
        Battle.printStatistics(party1);
        Battle.printStatistics(party2);

        // party1 battles party2
        Party winners = Battle.resolve(party1, party2);
        if (winners != null) {
            System.out.println("Winning " + winners);
        } else {
            System.out.println("Resolve ended in a tie.");
        }
        
        // mage1 battles mage2
        Character winner = Battle.singleCombat(mage1, mage2);
        if (winner != null) {
            System.out.println("Winner is " + winner);
        } else {
            System.out.println("Single Combat ended in a tie.");
        }
    }
}
