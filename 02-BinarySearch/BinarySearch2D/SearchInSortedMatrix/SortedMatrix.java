package SearchInSortedMatrix;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix ={
            {1, 3, 5, 7}, 
            {10, 11, 16, 20}, 
            {23, 30, 34, 60}, 
        };

        int target = 3;
        System.out.println(Arrays.toString(search(matrix, target)));
    }

    //Take middle column and binary search on it
    //case 1: if element == target
    //case 2: element > target -> ignore rows after it
    //case 3: element < target -> ignore above rows


    static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //be cautious, matrix may be empty

        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols/2;

        //run the loop till two rows are remining
        while (rStart < rEnd - 1 ) { //While this is true it will have more than two
            int mid = rStart+(rEnd - rStart)/2;
            
            if(matrix[mid][cMid] == target){
                return new int[]{mid, cMid};
            }
            
            if(matrix[mid][cMid] < target){
                rStart = mid;
            }else{
                rEnd = mid;
            }
        }

        //now we have two rows
        //check whether the target is in the col of 2 rows

        if(matrix[rStart][cMid] == target){
            return new int[]{rStart, cMid};
        }

        if(matrix[rStart + 1 ][cMid] == target){
            return new int[]{rStart + 1, cMid};
        }

        //search in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }
        //search in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix, rStart, cMid+1, cols-1, target);
        }
        //search in 3rd half
        if(target <= matrix[rStart+1][cMid-1]){
            return binarySearch(matrix, rStart + 1, 0, cMid-1, target);
        }else{
            //search in 4th half
            return binarySearch(matrix, rStart + 1, cMid+1, cols-1, target);
        }
        
        
    }

    //search int the row provided between the column provided 
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while (cStart <= cEnd) {
            int mid = cStart+(cEnd-cStart)/2;
            
            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if(matrix[row][mid] < target){
                cStart = mid+1;
            }else{
                cEnd = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
