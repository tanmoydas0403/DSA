package com.program3;
//Given a array nums of  integers, retun how many of them contain an even number of digits
public class EvenNumber {
    public static void main(String[] args) {
        int[] nums= {12, 345, 2, 6102, 7896};
        System.out.println(checkArray(nums));
    }

    private static int checkArray(int[] nums) {
        int count=0;
        for(int a:nums){
            if(even(a)){
                count++;
            }
        }
        return count;
    }

    private static boolean even(int a) {
//        int count=0;
//        while(a>0){
//            a=a/10;
//            count++;
//        }

        int count=(int)(Math.log10(a))+1;
        return count % 2==0;
    }

}
