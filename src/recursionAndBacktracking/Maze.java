/**
 * You are given a 2D array that represents a maze. It can have 2 values - 0 and 1. 1 represents a wall and 0 represents a path. The objective of the maze is to reach the bottom right corner, or A[A.length-1][A.length-1]. You start from A[0][0] and can only go in 4 directions - up, down, left or right. Find if a path exists.
 *
 * For example, a path exists in the following maze:
 *
 * |0|1|1|1|
 * |0|0|0|1|
 * |1|0|0|1|
 * |1|1|0|0|
 */
package recursionAndBacktracking;

import javafx.util.Pair;

import java.util.Arrays;

import static util.Utils.printInput;

/**
 * @author mandeep
 */
public class Maze {
    public static void main(String[] args) {
        printInput(isPathExist(null));
        printInput(isPathExist(new Integer[][]{
                { 0, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 0 },
        }));
        printInput(isPathExist(new Integer[][]{
                { 0, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
        }));
    }
    
    private static boolean isPathExist(Integer[][] arr) {
        if ( arr == null || arr.length == 0) {
            return false;
        }
        
        State[][] memo = new State[arr.length][arr[0].length];
        for (State[] states: memo) {
            Arrays.fill(states, State.UNVISITED);
        }
        return isPathExists(arr, 0, 0, memo);
    }
    
    private static boolean isPathExists(Integer[][] arr, int i, int j, State[][] memo) {
        if (outOfBounds(arr, i, j) || arr[i][j] == 1) {
            return false;
        }
        if ( i == arr.length - 1 && j == arr[0].length - 1) {
            return true;
        }
        if (memo[i][j] == State.PATH_NOT_FOUND || memo[i][j] == State.VISITING) {
            return false;
        }
        
        memo[i][j] = State.VISITING;
        Pair[] points = {
          new Pair<>(i + 1, j),
          new Pair<>(i - 1, j),
          new Pair<>(i, j + 1),
          new Pair<>(i, j - 1),
        };
        
        for (Pair point : points) {
            if (isPathExists(arr, (int) point.getKey(), (int) point.getValue(), memo)) {
                return true;
            }
        }
        memo[i][j] = State.PATH_NOT_FOUND;
        return false;
    }
    
    private static boolean outOfBounds(Integer[][] arr, int i , int j) {
        return i < 0 || i >= arr.length || j < 0 || j >= arr[0].length;
    }
    
    private enum State {
        VISITING,
        UNVISITED,
        PATH_NOT_FOUND
    }
}
