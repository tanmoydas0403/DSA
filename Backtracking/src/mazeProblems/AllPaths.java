package mazeProblems;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] boards = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        allPath("", boards, 0, 0);

        int[][] path = new int[boards.length][boards[0].length];
        allPathPrint("", boards, 0, 0, path, 1);

    }
    static void allPath(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // Mark the cell as visited
        maze[r][c] = false;

        // Move Down
        if(r < maze.length - 1){
            allPath(p + 'D', maze, r + 1, c);
        }

        // Move Right
        if(c < maze[0].length - 1){
            allPath(p + 'R', maze, r , c + 1);
        }

        // Move Up
        if(r > 0){
            allPath(p + 'U', maze, r - 1, c);
        }

        // Move Left
        if(c > 0){
            allPath(p + 'L', maze, r, c - 1);
        }

        // Unmark the cell (backtrack)
        maze[r][c] = true;
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // Mark the cell as visited
        maze[r][c] = false;

        path[r][c] = step;

        // Move Down
        if(r < maze.length - 1){
            allPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }

        // Move Right
        if(c < maze[0].length - 1){
            allPathPrint(p + 'R', maze, r , c + 1, path, step + 1);
        }

        // Move Up
        if(r > 0){
            allPathPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }

        // Move Left
        if(c > 0){
            allPathPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }

        // Unmark the cell (backtrack)
        maze[r][c] = true;
    }
}
