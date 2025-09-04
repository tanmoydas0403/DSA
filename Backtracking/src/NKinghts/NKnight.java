package NKinghts;

public class NKnight {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int totalWays = knight(board, 0, 0, 4);
        System.out.println("Total valid configurations: " + totalWays);
    }

    static int knight(boolean[][] board, int row, int col, int knightsRemaining) {
        if (knightsRemaining == 0) {
            // display(board); // Optional: show each configuration
            return 1;
        }

        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        if (col == board.length) {
            return knight(board, row + 1, 0, knightsRemaining);
        }

        int count = 0;

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += knight(board, row, col + 1, knightsRemaining - 1);
            board[row][col] = false;
        }

        count += knight(board, row, col + 1, knightsRemaining);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int[][] moves = {
                {-2, -1}, {-1, -2}, {-2, +1}, {-1, +2}
        };
        for (int[] move : moves) {
            int r = row + move[0];
            int c = col + move[1];
            if (isValid(board, r, c) && board[r][c]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "K   " : "X   ");
            }
            System.out.println();
        }
    }
}