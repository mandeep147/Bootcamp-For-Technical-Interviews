package com.chapter1.arraysandstrings.reverseArrayTraversal;


import static com.utils.Utils.checkIfArrayIsNull;
import static com.utils.Utils.printArray;

/**
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8].
 * Assume that the array has enough space to accommodate the result.
 */
public class CloneEvenNumber {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 6, 8};
        Integer[] reversedArr = cloneEvenNumbersNewArray(arr);
        printArray(reversedArr);
        Integer[] arr1 = {1, 2, 5, 6, 8, -1, -1, -1};
        Integer[] reversed = cloneEvenNumbers(arr1);
        printArray(reversed);
    }

    private static Integer[] cloneEvenNumbers(Integer[] arr){
        if (checkIfArrayIsNull(arr))
            return arr;
        int end = arr.length, i = getLastNumber(arr);
        while (i >= 0) {
            if(arr[i] % 2 == 0){
                arr[--end] = arr[i];
            }
            arr[--end] = arr[i];
            i--;
        }
        return arr;
    }

    private static int getLastNumber(Integer[] arr) {
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == -1) {
            i--;
        }
        return i;
    }
    
    // if new array can be allocated
    private static Integer[] cloneEvenNumbersNewArray(Integer[] arr) {
        if (checkIfArrayIsNull(arr))
            return arr;
        int evenLen = 0;
        for (Integer anArr : arr) {
            if (anArr % 2 == 0) {
                evenLen++;
            }
        }
        Integer[] res = new Integer[2 * evenLen + (arr.length - evenLen)];
        int j = 0;
        for (Integer anArr : arr) {
            if (anArr % 2 == 0) {
                res[j++] = anArr;
            }
            res[j++] = anArr;
        }
        return res;
    }
}
