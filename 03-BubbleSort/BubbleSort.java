import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr= {1,3,5,4};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean swap = true;

        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swap = false;
            //for each other, max item will come at the last 
            //respective index
            for (int j = 1; j < arr.length-i; j++) {
                //swap tohe item if the item is smaller than the previous item
                if(arr[j] < arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }

            if(!swap){
                break;
            }
        }
    }
}