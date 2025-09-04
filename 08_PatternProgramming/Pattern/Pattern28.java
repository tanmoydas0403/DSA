package Pattern;

public class Pattern28 {
    public static void main(String[] args) {
        int n = 5;
        pattern28(n);
    }
    static void pattern28(int n){
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;

            int numberOfSpaces = n - totalColsInRow;
            for (int i = 0; i < numberOfSpaces; i++) {
                System.out.print(" ");
            }

            for(int col = 0; col < totalColsInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
