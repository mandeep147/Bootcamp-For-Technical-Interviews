package com.chapter1.arraysandstrings.reverseArrayTraversal;


import static com.utils.Utils.printArray;

/**
 * Given an array of numbers, replace each even number with two of the same number.
 * e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8].
 * Assume that the array has enough space to accommodate the result.
 */
public class CloneEvenNumber {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 6, 8, -1, -1, -1};
        Integer[] reversedArr = cloneEvenNumbers(arr);
        printArray(reversedArr);
    }

    public static Integer[] cloneEvenNumbers(Integer[] arr){
        if(arr == null || arr.length == 0)
            return arr;
        int end = arr.length, i = getLastNumber(arr);
               while(i >= 0) {
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
        while(i >= 0 && arr[i] == -1){
            i--;
        }
        return i;
    }
}
