/**
 * Rotate a 2D array clockwise by 90 degrees, like rotating the pixels of an image.
 */
package arraysAndStrings;

import static util.Utils.print2DMatrix;

/**
 * @author mandeep
 */
public class Rotate2DArray {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateClockWise90Degrees(matrix);
        rotateAntiClockWise90Degrees(matrix);
        rotateClockWise90DegreesRotateSqPlane(matrix);
        rotateAntiClockWise90DegreesSqPlane(matrix);
    }
    
    /**
     * transpose the matrix and swap columns
     *
     * @param mat
     */
    private static void rotateClockWise90Degrees(Integer[][] mat) {
        if (mat == null || mat[0].length == 0) {
            return;
        }
        int len = mat.length;
        //transpose
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //swap columns
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][len - j - 1];
                mat[i][len - j - 1] = temp;
            }
        }
        print2DMatrix(mat);
    }
    
    // rotate 1st element of 1st row, last row, 1st col and last column,
    // rotate second element of 1st , last row and 1st and last ol and son, then move to inner sq
    private static void rotateClockWise90DegreesRotateSqPlane(Integer[][] mat) {
        if (mat == null || mat[0].length == 0) {
            return;
        }
        int len = mat.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[len - 1 - j][i]; // move from left to top
                mat[len - 1 - j][i] = mat[len - 1 - i][len - 1 - j]; // move from top to right
                mat[len - 1 - i][len - 1 - j] = mat[j][len - 1 - i]; // move right to bottom
                mat[j][len - 1 - i] = temp;
            }
        }
        print2DMatrix(mat);
    }
    
    // transpose then swap rows
    private static void rotateAntiClockWise90Degrees(Integer[][] mat) {
        if (mat == null || mat[0].length == 0) {
            return;
        }
        int len = mat.length;
        //transpose
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // swap rows
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[len - 1 - i][j];
                mat[len - 1 - i][j] = temp;
            }
        }
        
        print2DMatrix(mat);
    }
    
    // similar to clock wise sq plane
    private static void rotateAntiClockWise90DegreesSqPlane(Integer[][] mat) {
        if (mat == null || mat[0].length == 0) {
            return;
        }
        int len = mat.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][len - 1 - i]; // move from right to top
                mat[j][len - 1 - i] = mat[len - 1 - i][len - 1 - j]; // move from bottom to right
                mat[len - 1 - i][len - 1 - j] = mat[len - 1 - j][i]; // move from left to bottom
                mat[len - 1 - j][i] = temp; // update left
            }
        }
        print2DMatrix(mat);
    }
}
