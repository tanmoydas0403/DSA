/*  Insertion Sort 
 * why we use?
 Adaptive: steps got reduced if array is sorted, No of swaped
 reduced as compare bubble sort
 stable: order not changed
 use for smaller value of n, works good when array is patially sorted
 */

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr= {3,2,1,4,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
    }

    static void sort(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
            
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}