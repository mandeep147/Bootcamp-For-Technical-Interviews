/**
 * ShortestUnsortedSubarray
 * Level: Medium
 * Given an array of integers, find the shortest sub array, that if sorted, results in the entire array being sorted.
 * <p>
 * For example:
 * [1,2,4,5,3,5,6,7] --> [4,5,3] - If you sort from indices 2 to 4, the entire array is sorted.
 * [1,3,5,2,6,4,7,8,9] --> [3,5,2,6,4] -  If you sort from indices 1 to 5, the entire array is sorted
 */
package chapter1.arraysandstrings.traverseFromBothEnds;

import javafx.util.Pair;

import static util.Utils.checkIfArrayIsNull;
import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class ShortestUnsortedSubarray {
    public static void main(String args[]) {
        Integer[] arr = {1, 3, 5, 2, 6, 4, 8, 7, 8, 9};
        printInput(sort(arr));
    }
    
    private static Pair<Integer, Integer> sort(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            return null;
        int i, j;
        // find first drop
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        
        // find first bump
        for (j = arr.length - 1; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                break;
            }
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        // find min and max between i and j
        for (int k = i; k <= j; k++) {
            if (arr[k] < min) {
                min = arr[k];
            }
            
            if (arr[k] > max) {
                max = arr[k];
            }
        }
        
        // expand i to left
        while (i > 0 && arr[i - 1] > min) {
            i--;
        }
        
        // expand j to the right
        while (j < arr.length - 1 && arr[j + 1] < max) {
            j++;
        }
        
        return new Pair<>(i, j);
    }
}
