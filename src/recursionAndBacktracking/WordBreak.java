/**
 * Given a String S, which contains letters and no spaces, find if it can be broken it into valid words.
 * Return one such combination of words. Assume you are provided a dictionary of English words.
 *
 * For example:
 * S = "ilikemangotango"
 * Output: any one of the following:
 * "i like mango tango"
 * "i like man go tan go"
 * "i like mango tan go"
 * "i like man go tango"
 */
package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class WordBreak {
    public static void main(String[] args) {
        printInput(wordBreak("ilovetangomango", new HashSet<>(Arrays.asList("i", "love", "go", "tan", "man", "mango", "tango"))));
        printInput(wordBreak("ilovetangomango", new HashSet<>(Arrays.asList("loves"))));
    }
    
    private static List<String> wordBreak(String str, HashSet<String> dictionary) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        State[] memo = new State[str.length()];
        Arrays.fill(memo, State.UNVISITED);
        List<String> result = new ArrayList<>();
        if (isWordBreakPossible(str, 0, memo, result, dictionary)) {
            return result;
        }
        return null;
    }
    
    private static boolean isWordBreakPossible(String str, int start, State[] memo, List<String> result, HashSet<String> dictionary) {
        if (start == str.length()) {
            return true;
        }
        if (memo[start] == State.NOT_FOUND) {
            return false;
        }
        
        for (int i = start; i < str.length(); i ++) {
            String currWord = str.substring(start, i + 1);
            if (dictionary.contains(currWord)) {
                result.add(currWord);
                if (isWordBreakPossible(str, i + 1, memo, result, dictionary)) {
                    return true;
                } else {
                    result.remove(result.size() - 1);
                    memo[i + 1] = State.NOT_FOUND;
                }
            }
        }
        return false;
    }
    
    private enum State {
        UNVISITED,
        NOT_FOUND
    }
}
