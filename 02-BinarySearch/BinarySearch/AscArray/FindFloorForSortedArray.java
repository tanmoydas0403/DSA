package BinarySearch.AscArray;

public class FindFloorForSortedArray {
    public static void main(String[] args) {
        int[] arr={11,22,33,44,55,77};
        int target=10;
        int ans = findfloor(arr, target);

        if(ans<0){
            System.out.println(ans);
        }else{
            System.out.println("Value is: "+arr[ans]);
        }
    }

    static int findfloor(int[] arr, int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid= start+(end-start)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(target<arr[mid]){
                end= mid-1;
            }else{
                start= mid+1;
            }
        }
        return end;
    }
    
}
