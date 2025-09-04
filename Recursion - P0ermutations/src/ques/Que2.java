package ques;

import java.util.ArrayList;

public class Que2 {
    public static void main(String[] args) {
        diceFace("", 4 , 6);
        System.out.println(diceFaceList("", 4, 6));
        System.out.println(diceFaceCount("",4, 6));
    }

    static void diceFace(String p, int target, int face){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face);
        }
    }

    static ArrayList<String> diceFaceList(String p, int target, int face){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceFaceList(p + i, target - i, face));
        }
        return list;
    }

    static int diceFaceCount(String p, int target, int face){
        if(target == 0){
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= face && i <= target; i++) {
            count = count + diceFaceCount(p + i, target - i, face);
        }
        return count;
    }
}
