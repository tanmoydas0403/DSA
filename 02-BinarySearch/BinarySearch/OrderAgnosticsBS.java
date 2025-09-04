package BinarySearch;

public class OrderAgnosticsBS {
    public static void main(String[] args) {
        //int[] arr={1,2,3,4,5,6,8};
        int[] arr={8,6,5,4,3,2,1};
        int target=7;
        int ans=orderAgnosticsBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticsBS(int[]arr, int target){
        int start=0;
        int end=arr.length-1;
        //find whether the array is sorted in ascending or decending
        boolean isAsc = arr[start]<arr[end];

        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(arr[mid]==target){
                return mid;
            }

            if(isAsc){
                if(target<arr[mid]){
                    end= mid-1;
                }else{
                    start=  mid+1;
                }
            }else{
                if(target>arr[mid]){
                    end= mid-1;
                }else{
                    start= mid+1;
                }
            }
        }
        return -1;
    }
}

