package Pattern;
public class Pattern31 {
    public static void main(String[] args) {
        int n = 3;
        printPattern(n);
    }

    static void printPattern(int n){
        int originalN = n;
        n = 2 * n; 
        for(int row = 0; row <= n; row++){
            for(int col = 0; col <= n; col++){
                int atEveryIndex = originalN - Math.min(Math.min(row, col),Math.min(n-col, n-row)) + 1;
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }
}
