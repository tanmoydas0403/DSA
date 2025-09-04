package Pattern;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        pattern1(n);
    }

    static void pattern1(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //When one row print then nedd a new line
            System.out.println();
        }
    }
}
