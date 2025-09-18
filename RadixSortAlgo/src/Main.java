import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println();
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        OptionalInt optionalMax = Arrays.stream(arr).max();
        if (optionalMax.isEmpty()) {
            System.out.println("Array is empty. Cannot perform radix sort.");
            return;
        }

        int max = optionalMax.getAsInt();

        // Do count sort for every digit from least significant to most significant
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Count array for digits 0–9

        // Count occurrences of digits at current exp
        for (int j : arr) {
            count[(j / exp) % 10]++;
        }
        System.out.println("Count array for exp = " + exp + ": " + Arrays.toString(count));

        // Transform count[] to cumulative positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        System.out.println("Updated count array for exp = " + exp + ": " + Arrays.toString(count));

        // Build output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.out.println("Output array for exp = " + exp + ": " + Arrays.toString(output));
        System.out.println();

        // Copy output back to original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}