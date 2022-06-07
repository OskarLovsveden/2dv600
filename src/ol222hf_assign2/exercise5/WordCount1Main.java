/**
 * WordCount1Main.java
 * Date: 06 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;

public class WordCount1Main {
    /**
     * Reads the words.txt file and loops through each word.
     * Each word is used for a new Word instance.
     * Each Word instance is added to a HashSet and a TreeSet.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            HashSet<Word> wordHSet = new HashSet<Word>();
            TreeSet<Word> wordTSet = new TreeSet<Word>();

            File file = new File("words.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                Word word = new Word(reader.next());
                wordHSet.add(word);
                wordTSet.add(word);
            }

            reader.close();

            for (Word word : wordTSet) {
                System.out.println(word);
            }

            System.out.println("The size of the word HashSet: " + wordHSet.size());
            System.out.println("The size of the word TreeSet: " + wordTSet.size());

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to access a file.");
            e.printStackTrace();
        }
    }
}
