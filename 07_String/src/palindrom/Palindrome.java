package palindrom;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abccb";
        System.out.println(test1(str));
    }

    static boolean test1(String str){
        str = str.toLowerCase();
//        for (int i = 0; i < str.length() / 2; i++) {
//            char start = str.charAt(i);
//            char end = str.charAt(str.length() - 1 - i);
//
//            if(start != end){
//                return false;
//            }
//        }

        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

       return true;
    }
}
