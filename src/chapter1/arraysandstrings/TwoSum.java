/**
 * TwoSum
 * 2 Sum Problem: Given a sorted array of integers, find two numbers in the array that sum to a given integer target.
 * For example, if a = [1,2,3,5,6,7] and target = 11, the answer will be 5 and 6.
 */
package chapter1.arraysandstrings;

import javafx.util.Pair;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class TwoSum {
    public static void main(String args[]) {
        Integer[] arr = {1, 2, 3, 5, 6, 7};
        int target = 11;
        Pair<Integer, Integer> res = twoSum(arr, target);
        printInput(res);
    }
    
    private static Pair<Integer, Integer> twoSum(Integer[] arr, int target) {
        if (checkIfArrayIsNull(arr))
            return null;
        
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else
                return new Pair<>(arr[start], arr[end]);
        }
        return null; // no valid pair found
    }
}
