package com.sub;

import java.util.ArrayList;

public class Ascii {
    public static void main(String[] args) {
        subSeqAscii("","abc");
        System.out.println(subseqAsciiRet("","abc"));
    }

    static void subSeqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subSeqAscii(p + ch, up.substring(1));
        subSeqAscii(p, up.substring(1));
        subSeqAscii(p + (ch + 0), up.substring(1));
    }

    static ArrayList<String> subseqAsciiRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> first = subseqAsciiRet(p + ch, up.substring(1));
        ArrayList<String> second = subseqAsciiRet(p, up.substring(1));
        ArrayList<String> thrid = subseqAsciiRet(p + (ch + 0),up.substring(1));

        first.addAll(second);
        first.addAll(thrid);
        return first;
    }
}
