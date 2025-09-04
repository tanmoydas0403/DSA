package ques;

import java.util.ArrayList;

/*
Give a string containing digits from 2 - 9 inclusive, return all
possible letter combinations that the number could represent. Return
the answer in any order.
A mapping of digit to letters (just like on the telephone buttons)
is given below. Note that 1 does not map to any letter.

Example 1:
Input: digits = "23"
Output: ["ad", "ac", "af", "bd", "be", "bf", "cd", "ce", "cf"]

Example 2:
Input: digits = ""
Output: []
*/
public class Que1 {
    public static void main(String[] args) {
        pad("","12");

        System.out.println(padList("","23"));

        int i = padCount("", "12");
        System.out.println(i);
    }

    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; //this will convert '2' into 2

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a'+i);
            pad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> padList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0'; //this will convert '2' into 2

        ArrayList<String> list = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a'+i);
            list.addAll( padList(p + ch, up.substring(1)) );
        }
        return list;
    }

    static int padCount(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return 1;
        }

        int digit = up.charAt(0) - '0'; //this will convert '2' into 2
        int count = 0;

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a'+i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
