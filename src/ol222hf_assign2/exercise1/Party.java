/**
 * Party.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

public class Party {
    private Character[] members;
    private int mageSpells;
    private int warriorAbilities;
    private int rogueAbilities;
    private int clericSpells;

    /**
     * Party constructur that takes an argument for the party members.
     * 
     * @param party an array of characters representing the party members.
     */
    public Party(Character[] party) {
        this.members = party;

        // Store amount of spells/abilities based on class type.
        for (Character character : party) {
            if (character instanceof Mage) {
                Mage mage = (Mage) character;
                mageSpells = mageSpells + mage.getKnownSpells().size();
            } else if (character instanceof Warrior) {
                Warrior warrior = (Warrior) character;
                warriorAbilities = warriorAbilities + warrior.getKnownAbilities().size();
            } else if (character instanceof Rogue) {
                Rogue rogue = (Rogue) character;
                rogueAbilities = rogueAbilities + rogue.getKnownAbilities().size();
            } else if (character instanceof Cleric) {
                Cleric cleric = (Cleric) character;
                clericSpells = clericSpells + cleric.getKnownSpells().size();
            }
        }
    }

    public int getNumberOfMembers() {
        return members.length;
    }

    public int getMageSpells() {
        return mageSpells;
    }

    public int getWarriorAbilities() {
        return warriorAbilities;
    }

    public int getRogueAbilities() {
        return rogueAbilities;
    }

    public int getClericSpells() {
        return clericSpells;
    }

    public int getSpells() {
        return mageSpells + clericSpells;
    }

    public int getAbilities() {
        return warriorAbilities + rogueAbilities;
    }

    /** 
     * Calculates average party level.
     * (sum of all party members levels divided by amount of party members)
     * 
     * @return the average party level.
     * */
    public int getAveragePartyLevel() {
        int sum = 0;

        for (Character member : members) {
            sum = sum + member.getLevel();
        }

        return sum / members.length;
    }

    /**
     * Calculates total sum of all party members' primary attributes.
     * 
     * @return the sum of all primary attributes of all party members.
     */
    public int getSumOfPrimaryAttributes() {
        int sum = 0;

        for (Character member : members) {
            sum = sum + member.getPrimaryAttribute();
        }

        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Party:\n");
        
        for (Character character : members) {
            sb.append(character +  "\n");
        }

        return sb.toString();
    }
}
