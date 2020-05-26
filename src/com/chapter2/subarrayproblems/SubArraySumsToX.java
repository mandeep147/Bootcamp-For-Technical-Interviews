/**
 * SubArraySumsToX
 * Level: Medium
 * Given an array of positive and negative integers, find a subarray whose sum equals X.
 * <p>
 * For example:
 * Input = [2,4,-2,1,-3,5,-3], X = 5
 * Result = [2,4,-2,1]
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
public class SubArraySumsToX {
    public static void main(String args[]) {
        Integer[] arr = {2, 4, -2, 1, -3, 5, -3};
        int target = 5;
        printInput(subarraySumsToX(arr, target));
    }
    
    private static Pair subarraySumsToX(Integer[] arr, int target) {
        if (checkIfArrayIsNull(arr))
            return null;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                return new Pair<>(0, i);
            }
            if (map.containsKey(sum - target)) {
                return new Pair<>(map.get(sum - target) + 1, i);
            }
            map.put(sum, i);
        }
        return null;
    }
}
