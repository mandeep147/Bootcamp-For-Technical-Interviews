/**
 * Print all subsets of an array of integers
 */
package recursionAndBacktracking;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArrayToIndex;

/**
 * @author mandeep
 */
public class AllSubsetsOfAnArray {
    public static void main(String[] args) {
        generateAllSubsets(new Integer[]{2, 3, 6});
    }
    
    private static void generateAllSubsets(Integer[] arr) {
        if (checkIfArrayIsNull(arr)) {
            return;
        }
        printSubset(arr, new Integer[arr.length], 0, 0);
    }
    
    private static void printSubset(Integer[] arr, Integer[] buffer, int startIndex, int bufferIndex) {
        printArrayToIndex(buffer, bufferIndex);
        if (bufferIndex == buffer.length || startIndex == arr.length) {
            return;
        }
        
        for (int i = startIndex; i < arr.length; i++) {
            buffer[bufferIndex] = arr[i];
            printSubset(arr, buffer, i + 1, bufferIndex + 1);
        }
    }
}
