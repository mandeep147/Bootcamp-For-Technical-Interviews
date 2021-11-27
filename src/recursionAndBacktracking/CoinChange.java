/**
 * Given a set of coin denominations, print out the different ways you can make a target amount.
 * You can use as many coins of each denomination as you like.
 *
 * For example: If coins are [1,2,5] and the target is 5, output will be:
 *
 * [1,1,1,1,1]
 *
 * [1,1,1,2]
 *
 * [1,2,2]
 *
 * [5]
 *
 * Note: we care about combinations not permutations, [1,2] and [2,1] are same
 */
package recursionAndBacktracking;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printArrayToIndex;

/**
 * @author mandeep
 */
public class CoinChange {
    public static void main(String[] args) {
        generateCoinCombinations(new Integer[]{1, 2, 5}, 5);
        generateCoinCombinations(new Integer[]{1, 2, 5}, 15);
    }
    
    private static void generateCoinCombinations(Integer[] arr, int target) {
        if (checkIfArrayIsNull(arr))
            return;
        printCoinChange(arr, target, new Integer[target], 0, 0, 0);
    }
    /**
     *
     * @param arr
     */
    private static void printCoinChange(Integer[] arr, int target, Integer[] buffer, int startIndex, int bufferIndex, int currentSum) {
        if (currentSum > target) {
            return;
        }
        
        if (currentSum == target) {
            printArrayToIndex(buffer, bufferIndex);
            return;
        }
        
        for (int i = startIndex; i < arr.length; i++) {
            buffer[bufferIndex] = arr[i];
            printCoinChange(arr, target, buffer, i, bufferIndex + 1, currentSum + arr[i]);
        }
    }
}
