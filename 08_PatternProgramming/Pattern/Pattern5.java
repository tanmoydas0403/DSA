package Pattern;

public class Pattern5 {
    public static void main(String[] args) {
        int n = 9;
        pattern5(n);
        pattern5Approach2(n);
    }   
    //approach 1
    static void pattern5(int n){
        for (int row = 1; row <= n; row++) {
            if(row <= n/2){
                for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            }else{
                for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            }
            //When one row print then nedd a new line
            System.out.println();
        }
    }
    
    //approach:2
    static void pattern5Approach2(int n){
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;
            for(int col = 0; col < totalColsInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
