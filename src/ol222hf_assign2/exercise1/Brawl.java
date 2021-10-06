/**
 * Brawl.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

/** Brawl extends Combat. */
public class Brawl extends Combat {
    private Party party1;
    private Party party2;
    private Party winners;

    /**
     * Class constructor for a brawl. Takes arguments for two parties.
     * 
     * @param party1 a Party that represents one of the sides fighting in the brawl.
     * @param party2 a Party that represents the other of the sides fighting in the brawl.
     */
    public Brawl(Party party1, Party party2) {
        super();
        this.party1 = party1;
        this.party2 = party2;
    }

    /** Starts a brawl and calulates the winners. */
    public void start () {
        boolean hasSameAmountOfPartyMembers = isOfEqualStats(party1.getNumberOfMembers(), party2.getNumberOfMembers());
        boolean hasSameAveragePartyLevel = isOfEqualStats(party1.getAveragePartyLevel(), party2.getAveragePartyLevel());
        boolean hasSameSumOfPrimaryAttributes = isOfEqualStats(party1.getSumOfPrimaryAttributes(), party2.getSumOfPrimaryAttributes());

        if (hasSameAmountOfPartyMembers && hasSameAveragePartyLevel && hasSameSumOfPrimaryAttributes) {
            // Tie, represented as null
            winners = null;
        } else if (hasSameAmountOfPartyMembers && !hasSameAveragePartyLevel) {
            // Won on average level
            winners = party1.getAveragePartyLevel() > party2.getAveragePartyLevel() ? party1 : party2;
        } else if (hasSameAmountOfPartyMembers && hasSameAveragePartyLevel) {
            // Won on sum of primary attributes
            winners = party1.getSumOfPrimaryAttributes() > party2.getSumOfPrimaryAttributes() ? party1 : party2;
        } else {
            // Won on number of characters/members
            winners = party1.getNumberOfMembers() > party2.getNumberOfMembers() ? party1 : party2;
        }
    }

    public Party getWinners() {
        return winners;
    }
}
