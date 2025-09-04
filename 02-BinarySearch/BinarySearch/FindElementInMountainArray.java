//Q.7. Find target Elemenet In Moutain Array

package BinarySearch;

public class FindElementInMountainArray {
    public static void main(String[] args) {
        int [] arr= {1,2,3,7,4,2};
        int target= 3;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target){
        int peek = peekIndexInMountainArray(arr);

        int firstSearch= orderAgnosticsBS(arr, target, 0, peek);
        if(firstSearch!=-1){
            return firstSearch;
        }
        //try to search in secend half
        return orderAgnosticsBS(arr, target, peek+1, arr.length-1);
    }
    
    public static int peekIndexInMountainArray(int[]arr){
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

    static int orderAgnosticsBS(int[]arr, int target, int start, int end){
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
