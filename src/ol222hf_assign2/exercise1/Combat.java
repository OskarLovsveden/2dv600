/**
 * Combat.java
 * Date: 27 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise1;

public abstract class Combat {
    /**
     * Compares two statistics in combat to see if they are equal.
     * 
     * @param stat1 the first statistic.
     * @param stat2 the second statistic.
     * @return true if they are equal, false otherwise.
     */
    protected static boolean isOfEqualStats(int stat1, int stat2) {
        return stat1 == stat2;
    }
}
