package mazeProblems;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(4, 4));
        System.out.println("-------------------------------");

        path("", 3, 3);
        System.out.println("-------------------------------");

        System.out.println(pathReturn("", 3, 3));
        System.out.println("-------------------------------");

        System.out.println(pathDiagonalReturn("",3, 3));
        System.out.println("-------------------------------");

        boolean[][] board ={
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestriction("", 0, 0 , board);
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = count (r - 1, c);
        int right = count (r, c - 1);

        return left + right;
    }

    static void path(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            path(p + 'D', r - 1, c);
        }
        if(c > 1){
            path(p + 'R', r, c - 1);
        }
    }

    static ArrayList<String> pathReturn(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(pathReturn(p + 'D', r - 1, c));
        }
        if(c > 1){
            list.addAll(pathReturn(p + 'R', r, c - 1));
        }
        return list;
    }

    static ArrayList<String> pathDiagonalReturn(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1 && c > 1){
            list.addAll(pathDiagonalReturn(p + 'D', r - 1, c - 1));
        }
        if(r > 1){
            list.addAll(pathDiagonalReturn(p + 'V', r - 1, c));
        }
        if(c > 1){
            list.addAll(pathDiagonalReturn(p + 'H', r, c - 1));
        }
        return list;
    }

    static void pathRestriction(String p, int r, int c, boolean[][] maze){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            pathRestriction(p + 'D', r + 1, c , maze);
        }
        if(c < maze[0].length - 1){
            pathRestriction(p + 'R', r, c + 1, maze);
        }
    }
}
