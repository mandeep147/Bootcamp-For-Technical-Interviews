/**
 * Print all permutations of length X.
 */
package recursionAndBacktracking;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArray;

/**
 * @author mandeep
 */
public class PermutationsLengthX {
    public static void main(String args[]) {
        generatePermutations(new Integer[]{1, 2, 3, 4}, 2);
        generatePermutations(new Integer[]{1, 2, 3}, 3);
    }
    
    private static void generatePermutations(Integer[] arr, int length) {
        if (checkIfArrayIsNull(arr)){
            return;
        }
        printAllPermutations(arr, new Integer[length], 0, new boolean[arr.length]);
    }
    
    private static void printAllPermutations(Integer[] arr, Integer[] buffer, int bufferIndex, boolean[] isInBuffer) {
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!isInBuffer[i]) {
                buffer[bufferIndex] = arr[i];
                isInBuffer[i] = true;
                printAllPermutations(arr, buffer, bufferIndex + 1, isInBuffer);
                isInBuffer[i] = false;
            }
        }
    }
}
