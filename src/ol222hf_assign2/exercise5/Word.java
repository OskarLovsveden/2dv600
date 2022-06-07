/**
 * Word.java
 * Date: 06 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise5;

/** Word class that implements Comparable. */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) {
        this.word = str;
    }

    public String toString() {
        return word;
    }

    /**
     * Creates and returns a hashcode from the word field, as lowercase.
     * 
     * @return the hashcode.
     */
    @Override
    public int hashCode() {
        return this.word.toLowerCase().hashCode();
    }

    /**
     * Checks whether the caller of this method is equal to another object.
     * 
     * @param other an object to check for equality.
     * @return true if other is an instance of Word, with a matching word
     *         field(ignoring casing), otherwise false.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word o = (Word) other;
            return this.word.equalsIgnoreCase(o.word);
        }

        return false;
    }

    /**
     * Compares this Word object with another Word object.
     * 
     * @param o the Word object to be compared against this.
     * @return true if they are comparable of eachother, otherwise false.
     */
    @Override
    public int compareTo(Word o) {
        return this.word.compareToIgnoreCase(o.word);
    }
}
