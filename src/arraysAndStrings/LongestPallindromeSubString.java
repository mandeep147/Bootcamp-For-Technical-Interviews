/**
 * Find the longest palindromic substring in a string. For example:
 * <p>
 * "abcababadef" => "ababa"
 * "ffabbahh" => "abba"
 */
package arraysAndStrings;

import static util.Utils.printArray;

/**
 * @author mandeep
 */
public class LongestPallindromeSubString {
    public static void main(String[] args) {
        printArray(longestPalindromeSubString(""));
        printArray(longestPalindromeSubString(null));
        printArray(longestPalindromeSubString("abcababadef"));
    }
    
    /**
     * Time: O(n^2)
     * Space: O(1)
     *
     * @param input
     * @return
     */
    private static Integer[] longestPalindromeSubString(String input) {
        if (input == null || input.isEmpty()) {
            return new Integer[]{-1, -1};
        }
        Integer[] res = new Integer[2];
        char[] ch = input.toCharArray();
        int longest = 1;
        // odd
        for (int i = 0; i < ch.length; i++) {
            int offset = 0;
            while (isValidIndex(ch, i - 1 - offset) && isValidIndex(ch, i + 1 + offset) && ch[i - 1 - offset] == ch[i + 1 + offset]) {
                offset++;
            }
            int longestAtI = offset * 2 + 1;
            if (longestAtI > longest) {
                longest = longestAtI;
                res[0] = i - offset;
                res[1] = i + offset;
            }
        }
        
        // even
        for (int i = 0; i < ch.length; i++) {
            int offset = 0;
            while (isValidIndex(ch, i - offset) && isValidIndex(ch, i + 1 + offset) && ch[i - offset] == ch[i + 1 + offset]) {
                offset++;
            }
            int longestAtI = offset * 2;
            if (longestAtI > longest) {
                longest = longestAtI;
                res[0] = i - offset;
                res[1] = i + offset;
            }
        }
        return res;
    }
    
    private static boolean isValidIndex(char[] arr, int i) {
        return i >= 0 && i < arr.length;
    }
    
    //2
    private static String longestPallindromicSubstringConstantSpace(String s) {
        if (s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;
        
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);
            if (temp.length() > longest.length())
                longest = temp;
            
            temp = helper(s, i, i + 1);
            if (temp.length() > longest.length())
                longest = temp;
        }
        
        return longest;
    }
    
    
    private static String helper(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
