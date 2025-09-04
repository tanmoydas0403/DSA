package BinarySearch;

public class BinearySearch {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,7};
        int target=6;
        int ans=binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            //find the middle element
            //below that case might be chance bere jabe int er range diye
            // int mid=(start+end)/2;
            int mid = start + (end-start) / 2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}