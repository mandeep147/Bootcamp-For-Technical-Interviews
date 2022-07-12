/**
 * Check if a string A is a rotation of another string B. For example, "atbobc" is a rotation of "bobcat".
 */
package arraysAndStrings;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class IsStringRotation {
    public static void main(String[] args) {
        printInput(isRotation("bobcat", "atbobc"));
        printInput(isRotation("bcat", "at"));
    }
    
    private static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
