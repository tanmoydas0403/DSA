//Q.6. Peak Index in a Mountain array.

package BinarySearch;

public class MountainArray {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,7,6,3,2};
        int ans = binarySearch(arr1);
        System.out.println(ans); 
    }

    public static int binarySearch(int[]arr){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid= start+(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    } 
}