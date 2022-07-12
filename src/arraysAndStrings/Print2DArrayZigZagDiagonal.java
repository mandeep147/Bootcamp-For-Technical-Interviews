/**
 * Print2DArrayZigZagDiagonal
 */
package arraysAndStrings;


import java.util.*;

import static util.Utils.printArray;

/**
 * @author mandeep
 */
public class Print2DArrayZigZagDiagonal {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printArray(printZingZagOrder(matrix));
    }
    
    private static Integer[] printZingZagOrder(Integer[][] arr) {
        if (arr == null || arr[0].length == 0) {
            return new Integer[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxIndexSum = 0;
        Integer[] res = new Integer[arr.length * arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                map.computeIfAbsent(i+j, x -> new ArrayList<>()).add(arr[i][j]);
                maxIndexSum = Math.max(maxIndexSum, i+j);
            }
        }
        int resIdx = 0;
        for(int i = 0; i <= maxIndexSum; i++) {
            List<Integer> list = map.get(i);
            if(i % 2 == 0) {
                Collections.reverse(list);
            }
            for(Integer num: list) {
                res[resIdx++] = num;
            }
        }
        return res;
    }
}
