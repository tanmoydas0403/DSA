package SudokoSolver;

public class SudokuSolverOptimize {
    private static final int SIZE = 9;
    private static final int SUBGRID = 3;

    // Track used numbers in rows, columns, and boxes
    private static boolean[][] rows = new boolean[SIZE][SIZE + 1];
    private static boolean[][] cols = new boolean[SIZE][SIZE + 1];
    private static boolean[][] boxes = new boolean[SIZE][SIZE + 1];

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Pre-fill tracking arrays
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int num = board[i][j];
                if (num != 0) {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[getBoxIndex(i, j)][num] = true;
                }
            }
        }

        if (solve(board, 0, 0)) {
            System.out.println("✅ Solved Sudoku:");
            display(board);
        } else {
            System.out.println("❌ No solution exists.");
        }
    }

    static boolean solve(int[][] board, int row, int col) {
        if (row == SIZE) return true;
        if (col == SIZE) return solve(board, row + 1, 0);
        if (board[row][col] != 0) return solve(board, row, col + 1);

        for (int num = 1; num <= SIZE; num++) {
            int boxIdx = getBoxIndex(row, col);
            if (!rows[row][num] && !cols[col][num] && !boxes[boxIdx][num]) {
                board[row][col] = num;
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = true;

                if (solve(board, row, col + 1)) return true;

                // Backtrack
                board[row][col] = 0;
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = false;
            }
        }
        return false;
    }

    private static int getBoxIndex(int row, int col) {
        return (row / SUBGRID) * SUBGRID + (col / SUBGRID);
    }

    private static void display(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
