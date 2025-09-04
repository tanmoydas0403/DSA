package BinarySearch.AscArray;

public class FindCellingForSortedArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,7};
        int target=8;

        int cellingIndex = findCelling(arr, target);

        if(cellingIndex<0){
            System.out.println("-1");
        }else{
            System.out.println(arr[cellingIndex]);
        }
        
    }

    static int findCelling(int[] arr, int target){
        int start=0;
        int end=arr.length-1;

        if(target>arr[end]){
            return -1;
        }

        while(start<=end){
            int mid= start+(end-start)/2;
            
            if(arr[mid]==target){
                return mid;
            }

            if (target<arr[mid]) {
                end= --mid;
            }else{
                start=++mid;
            }    
        }

        return start;
    }
    
}
