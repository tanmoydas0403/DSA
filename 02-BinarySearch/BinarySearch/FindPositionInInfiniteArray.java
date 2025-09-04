// Q.5:Find position of element in a sorted array of infinite numbers.

package BinarySearch;

public class FindPositionInInfiniteArray {
    public static void main(String[] args) {
        int[] arr={2,3,5,6,7,8,10,11,12,15,20,23,30};
        int target=7;
        int ans = findingRange(arr, target);
        System.out.println(ans);
    }

    static int findingRange(int[]arr, int target){
        //first find the range 
        // first start with a box of size 2

        int start = 0;
        int end = 1;

        //condition for the target to lie in thee range
        while(target>arr[end]){
            int newStart= end+1;
            //double the box value
            //end = previous end+ sizeofbox*2
            end= end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, start, end, target);
    }

    public static int binarySearch(int[]arr, int start, int end, int target){
        while(start<=end){
            int mid= start+(end-start)/2;

            if(target<arr[mid]){
                end= mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
