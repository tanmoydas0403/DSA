package Q1;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int length = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String current = q.poll();

                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[j] = ch;
                        String nextWord = new String(temp);

                        if (nextWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            q.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }

            length++;
        }

        return 0;
    }
}