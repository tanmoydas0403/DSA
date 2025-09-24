package Q1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = wl.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result);
    }
}