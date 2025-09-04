import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //find the max item in the remaining array and swap with correct index
            int lastIndex = arr.length-i-1;
            int maxIndex = getMaxIndex(arr , 0 , lastIndex);
            swap(arr,maxIndex,lastIndex);
        }
    }
    private static int getMaxIndex(int[] arr, int startIndex, int lastIndex) {
        int max = startIndex;
        for (int i = startIndex; i <= lastIndex; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
}
