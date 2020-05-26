/**
 * LongestSubstringWithUniqueCharacters
 * Level: Medium
 * <p>
 * Given a String, find the longest substring with unique characters.
 * <p>
 * For example: "whatwhywhere" --> "atwhy"
 * <p>
 * return start and end indexes
 */
package com.chapter2.subarrayproblems;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

import static com.utils.Utils.printInput;

/**
 * @author mandeep
 */
public class LongestSubstringWithUniqueCharacters {
    public static void main(String args[]) {
        String str = "whatwhywhere";
        printInput(longestSubstringWithUniqueChars(str));
    }
    
    private static Pair longestSubstringWithUniqueChars(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        
        int start = 0, end = 0, length = 1;
        Map<Character, Integer> map = new HashMap<>();
        Pair<Integer, Integer> res = new Pair<>(0, 0);
        map.put(str.charAt(0), 0); // insert first char into map
        while (end < str.length() - 1) {
            end++;
            char currentChar = str.charAt(end);
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }
            map.put(currentChar, end);
            if (end - start + 1 > length) {
                length = end - start + 1;
                res = new Pair<>(start, end);
            }
        }
        
        return res;
    }
}
