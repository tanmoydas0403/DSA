public class RotatedSortedArrayForDuplicate {
    public static void main(String[] args) {
        int[] arr= {2,3,9,2,2,2};
        int target = 3;
        System.out.println(findPivotWithDuplicates(arr));
        System.out.println(search(arr, target));
        
    }

    
    static int search(int[]arr, int target){
        int pivot = findPivotWithDuplicates(arr);
        if(pivot == -1){
            //just do normal binary search
            return binarySearch(arr, target, 0, arr.length-1);
        }
        
        //if pivot is found, check if target is in first half or second half
        
        if(arr[pivot] == target){
            return pivot;
        }

        if(target >=arr[0]){
            return binarySearch(arr, target, 0, pivot-1);
        }
            
        return binarySearch(arr, target, pivot+1, arr.length-1);
        
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            //4 cases over here
            //Case 1
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }

            //Case 2
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

           //if elements at middle, start, end are equal then just
           //skip the duplicates
           if(arr[mid] == arr[start] && arr[mid] == arr[end]){
            //skip the elements
            //NOTE: what if these elements at start and end were the pivot?
            //check if start is pivot
            if(arr[start] > arr[start+1]){
                return start;
            }
            start++;
            //check if end is pivot
            if(arr[end] < arr[end-1]){
                return end-1;
            }
            end--;
           }
           //left side is sorted, so privot should be in right
           else if(arr[start]<arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
            start = mid+1;   
            
           }
           else{
            end = mid-1;   
           } 
        }
        return -1;
    }
    
}
 