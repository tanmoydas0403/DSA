package NQueenProblem;

public class NQueensOptimized {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    static int solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // row - col + n - 1
        int[] queens = new int[n]; // queens[row] = col
        return placeQueens(0, n, cols, diag1, diag2, queens);
    }

    static int placeQueens(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2, int[] queens) {
        if (row == n) {
            display(queens, n);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                queens[row] = col;
                cols[col] = diag1[d1] = diag2[d2] = true;

                count += placeQueens(row + 1, n, cols, diag1, diag2, queens);

                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
        return count;
    }

    static void display(int[] queens, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    System.out.print("Q   ");
                } else {
                    System.out.print("X   ");
                }
            }
            System.out.println();
        }
    }
}
