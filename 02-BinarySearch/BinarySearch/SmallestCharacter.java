//Q.3. Find the smallest character in array larger than target element
package BinarySearch;

public class SmallestCharacter {

    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'j';
        
        char ans = nextGreatestLetter(arr, target);
        System.out.println(ans);
    }

    public static char nextGreatestLetter(char[] letters, char target){
        int start = 0;
        int end=letters.length-1;

        while(start<=end){
            int mid= start+(end-start)/2;

            if(target<letters[mid]){
                end= --mid;
            }else{
                start= mid+1;
            }
        }
        return letters[start%letters.length];
    }


}