/**
 * Given a 9x9 partially filled array, find a way to fill it
 * such that each row, column and 3x3 sub-grid contain exactly one instance of digits 1-9.
 *
 * SudokuSolver:Given a Sudoku board, find a solution. The board can have some squares filled out already.
 * You have to fill the rest of the squares.
 * (Rules of Sudoku are as follows: In each column, row and 3 x 3 square, you cannot have duplicate numbers.
 * Also, only numbers 1-9 are allowed.)
 */
package recursionAndBacktracking;

import static util.Utils.print2DMatrix;

/**
 * @author mandeep
 */
public class SudokuSolver {
    public static void main(String[] args) {
        // 0 represents empty cell
        Integer[][] board = new Integer[][]{
                { 5, 3, 0, 0, 7, 0 ,0 ,0 ,0 },
                { 6, 0, 0, 1, 9, 5, 0, 0 ,0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 },
        };
        solveSudoku(board);
    }
    
    /**
     * Time: O(9^n)
     * Space: O(m*n); although no extra space is used here
     * @param board
     */
    public static void solveSudoku(Integer[][] board) {
        BoardChecker checker = new BoardChecker(board);
        boolean success = sudokuSolver(board, 0, 0, checker);
        if (!success) {
            throw new IllegalArgumentException("No solution found");
        } else {
            print2DMatrix(board);
        }
    }
    
    private static boolean sudokuSolver(Integer[][] board, int i, int j, BoardChecker checker) {
        if (i == board.length) {
            return true;
        }
        
        Pair next = nextSquare(i, j);
        
        if (board[i][j] != 0) {
            return sudokuSolver(board, next.i(), next.j(), checker);
        }
        
        for(int candidate = 1; candidate <= 9; candidate++) {
            if (checker.canPlace(i, j, candidate)) {
                checker.place(i, j, candidate);
                board[i][j] = candidate;
                if (sudokuSolver(board, next.i(), next.j(), checker)) {
                    return true;
                }
                checker.remove(i, j, candidate);
                board[i][j] = 0;
            }
        }
        return false;
    }
    
    private static Pair nextSquare(int i, int j) {
        if (j == 8) {
            return new Pair(i + 1, 0);
        } else {
            return new Pair(i, j+ 1);
        }
    }
    public static class BoardChecker {
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        
        public BoardChecker(Integer[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != 0) {
                        place(i, j, board[i][j]);
                    }
                }
            }
        }
        
        private boolean place (int i , int j, int number) {
            if (!canPlace(i, j, number)) {
                return false;
            }
            row[i][number] = true;
            column[j][number] = true;
            box[boxNumber(i, j)][number] = true;
            return true;
        }
        
        private boolean canPlace(int i, int j, int number) {
            return !row[i][number] && !column[j][number] && !box[boxNumber(i, j)][number];
        }
        
        private int boxNumber(int i, int j) {
            // Note: (i/3) * 3 is not the same as i.
            // for int values, i/3 gets reduced to floor(i/3).
            return (i/3) * 3 + (j/3);
        }
        
        private void remove(int i, int j, int number) {
            row[i][number] = false;
            column[j][number] = false;
            box[boxNumber(i, j)][number] = false;
        }
    }
    
    public static class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        public int i() {
            return i;
        }
        
        public int j() {
            return j;
        }
    }
}
