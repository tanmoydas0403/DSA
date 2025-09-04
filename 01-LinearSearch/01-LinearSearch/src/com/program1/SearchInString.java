package com.program1;

public class SearchInString {
    public static void main(String[] args) {
        String name="Tanmoy";
        char target = 'a';

        System.out.println(searchCh(name, target));
    }

//    private static boolean searchCh(String name, char target) {
//        if(name.isEmpty())
//            return false;
//        for (int i = 0; i < name.length(); i++) {
//            if(target == name.charAt(i))
//                return true;
//        }
//        return false;
//    }

    private static boolean searchCh(String name, char target) {
        if(name.isEmpty())
            return false;
        for(char ch: name.toCharArray())
            if(ch==target)
                return true;
        return false;
    }
}
