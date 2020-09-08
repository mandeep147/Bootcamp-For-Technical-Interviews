/**
 * Given a sorted array whose length is not known, perform binary search for a target T.
 * Do the search in O(log(n)) time. Return the index of the element
 */
package chapter5.binarysearch;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class FindTargetWithUnknownLength {
    public static void main(String args[]) {
        Integer[] arr = {1, 3, 4, 6, 7};
        int target = 6;
        printInput(findTargetWithUnknownLength(arr, target));
        
    }
    
    
    private static int findTargetWithUnknownLength(Integer[] arr, int target) {
        // TODO
        return 0;
    }
}
