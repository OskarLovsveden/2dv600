/**
 * Battle.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

public class Battle {
    /**
     * Prints the statistics of a party.
     * 
     * @param party represents the party with an array or characters.
     */
    public static void printStatistics(Character[] party) {
        Party p = new Party(party);
        
        String statistics =
            "Party's average level: " + p.getAveragePartyLevel() + "\n" +
            "Total number of spells: " + p.getSpells() + "\n" +
            "Total number of mage spells: " + p.getMageSpells() + "\n" +
            "Total number of cleric spells: " + p.getClericSpells() + "\n" +
            "Total number of abilities: " + p.getAbilities() + "\n" +
            "Total number of warrior abilities: " + p.getWarriorAbilities() + "\n" +
            "Total number of rogue abilities: " + p.getRogueAbilities() + "\n";
        System.out.println(statistics);
    }
    
    /**
     * Finds the winners of a fight between two parties of characters.
     * 
     * @param party1 a party of characters.
     * @param party2 a second party of characters.
     * @return the winning party.
     */
    public static Party resolve(Character[] party1, Character[] party2) {
        Party p1 = new Party(party1);
        Party p2 = new Party(party2);

        Brawl brawl = new Brawl(p1, p2);
        brawl.start();
        return brawl.getWinners();
    }
    
    /**
     * Finds the winner in a fight between two characters of the same type, i.e Mage vs. Mage, etc.
     * 
     * @param c1 a character.
     * @param c2 a character.
     * @return the winning character.
     */
    public static Character singleCombat(Character c1, Character c2) {
        Duel duel = new Duel(c1, c2);
        duel.start();
        return duel.getWinner();
    }
}
