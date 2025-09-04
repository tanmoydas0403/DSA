package com.questions.q6;

public class MinInsertDoubleClose {

    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0; // count of unmatched '('
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                i++;
            } else { // ch == ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Found a complete '))'
                    if (open > 0) {
                        open--; // match with a '('
                    } else {
                        insertions++; // need to insert a '('
                    }
                    i += 2;
                } else {
                    // Single ')' — need one more ')' to complete the pair
                    if (open > 0) {
                        open--;
                        insertions++; // insert one ')'
                    } else {
                        insertions += 2; // insert '(' and ')'
                    }
                    i++;
                }
            }
        }

        // Each unmatched '(' needs two ')'
        insertions += open * 2;
        return insertions;
    }

    public static void main(String[] args) {
        MinInsertDoubleClose solver = new MinInsertDoubleClose();

        String[] testCases = {
                "(()))",       // Output: 1
                "())",         // Output: 0
                "))())(",      // Output: 3
                "(",           // Output: 2
                ")))",         // Output: 3
                "(()(()",      // Output: 4
                "(()))(()))",  // Output: 0
        };

        for (String test : testCases) {
            int result = solver.minInsertions(test);
            System.out.println("Input: \"" + test + "\" → Insertions Needed: " + result);
        }
    }
}