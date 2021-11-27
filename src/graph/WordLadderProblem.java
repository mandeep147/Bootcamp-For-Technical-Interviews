/**
 * Word Ladder Problem: You are given 2 words A and B, both of the same length. Your task is to
 * transform one word to another - changing only one letter at a time. Each intermediate word
 * should be a valid word in the dictionary. Print out the length of the path.
 * For example,
 * A = CAB, B = DOG
 * Result: 4 (CAB -> COB -> COG -> DOG)
 *
 * LeetCode 127 (Not IC solution)
 */
package graph;

import java.util.Arrays;
import java.util.List;

/**
 * @author mandeep
 */
public class WordLadderProblem {
    public static void main(String args[]) {
        String start = "cab";
        String end = "dog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(wordLadder(start, end, wordList));
    }

    public static int wordLadder(String start, String end, List<String> wordList) {
        return -1;
    }
}
