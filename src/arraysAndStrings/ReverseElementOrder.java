package arraysAndStrings;

import util.Utils;

import static util.Utils.printArray;

/**
 * Reverse the order of elements in an array.
 * For example, A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
 */
public class ReverseElementOrder {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Integer[] reversedArr = reverseElements(arr);
        printArray(reversedArr);
    }

    private static Integer[] reverseElements(Integer[] arr) {
        if(arr == null || arr.length == 0)
            return arr;
        int start = 0, end = arr.length - 1;
        while(start < end){
            Utils.swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }
}
