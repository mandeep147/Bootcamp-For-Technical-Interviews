/**
 * Print all combinations of length 3.
 */
package recursionAndBacktracking;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArray;

/**
 * @author mandeep
 */
public class CombinationLength {
    public static void main(String[] args) {
        generateCombinations(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 3);
        generateCombinations(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 4);
        generateCombinations(new Integer[]{}, 4);
    }
    
    private static void generateCombinations(Integer[] arr, int lengthOfCombos) {
        if (checkIfArrayIsNull(arr)) {
            return;
        }
        printCombos(arr, new Integer[lengthOfCombos], 0, 0);
    }
    
    /**
     * Time Complexity: Factorial
     * Space Complexity: O(X) where X is length of buffer or combinations to generate
     * @param a
     * @param buffer
     * @param start
     * @param bufferIndex
     */
    private static void printCombos(Integer[] a, Integer[] buffer, int start, int bufferIndex) {
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }
        
        if (start == buffer.length) {
            return;
        }
        
        for (int i = start; i < a.length; i++) {
            buffer[bufferIndex] = a[i];
            printCombos(a, buffer, i + 1, bufferIndex + 1);
        }
    }
}
