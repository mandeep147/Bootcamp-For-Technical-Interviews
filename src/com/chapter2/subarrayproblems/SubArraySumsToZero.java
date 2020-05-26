/**
 * SubArray Sums To Zero
 * Level: Medium
 * Given an array of integers, both -ve and +ve, find a contiguous subarray that sums to 0.
 * <p>
 * For example:
 * [2,4,-2,1,-3,5,-3] --> [4,-2,1,-3]
 */
package com.chapter2.subarrayproblems;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

import static com.utils.Utils.checkIfArrayIsNull;
import static com.utils.Utils.printInput;

/**
 * @author mandeep
 */
public class SubArraySumsToZero {
    public static void main(String args[]) {
        Integer[] arr = {2, 4, -2, 1, -3, 5, -3};
        printInput(zeroSumSubArray(arr));
    }
    
    private static Pair zeroSumSubArray(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            return null;
        
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                return new Pair<>(0, i);
            }
            if (map.containsKey(sum)) {
                return new Pair<>(map.get(sum) + 1, i);
            }
            map.put(sum, i);
        }
        return null;
    }
}
