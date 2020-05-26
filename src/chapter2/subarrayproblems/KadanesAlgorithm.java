/**
 * Kadane's Algorithm
 * Level: Medium
 * Given an array of integers that can be both +ve and -ve,
 * find the contiguous subarray with the largest sum.
 * <p>
 * For example:
 * [1,2,-1,2,-3,2,-5]  -> first 4 elements have the largest sum. Return (0,3)
 * <p>
 * Output format: Return the value of the maximum sum
 */
package chapter2.subarrayproblems;

import javafx.util.Pair;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class KadanesAlgorithm {
    public static void main(String args[]) {
        Integer[] arr = {1, 2, -1, 2, -3, 2, -5};
        printInput(maximumSumSubarray(arr));
        // print indexes of subarray
        printInput(maxSumSubArrayIndex(arr));
    }
    
    /**
     * Time: O(n)
     * Space: O(1)
     * <p>
     * max_sum_ending_at[i] = Max(max_sum_ending_at[i-1] + a[i], a[i])
     *
     * @param arr
     * @return
     */
    private static Integer maximumSumSubarray(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            throw new IllegalArgumentException("Empty array, no largest sum");
        int maxSumAtI = arr[0], res = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            maxSumAtI = Math.max(maxSumAtI + arr[i], arr[i]);
            res = Math.max(maxSumAtI, res);
        }
        
        return res;
    }
    
    private static Pair<Integer, Integer> maxSumSubArrayIndex(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            throw new IllegalArgumentException("Empty array, no largest sum");
        int maxSumAtI = arr[0], res = arr[0], end = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            maxSumAtI = Math.max(maxSumAtI + arr[i], arr[i]);
            if (maxSumAtI > res) {
                res = maxSumAtI;
                end = i;
            }
        }
        int sum = 0;
        for (int i = end; i >= 0; i--) {
            sum += arr[i];
            if (sum == res) {
                return new Pair<>(i, end);
            }
        }
        return null;
    }
}
