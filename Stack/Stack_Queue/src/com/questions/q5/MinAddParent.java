package com.questions.q5;

import java.util.Stack;

public class MinAddParent {

    public static void main(String[] args) {
        MinAddParent fixer = new MinAddParent();

        String[] testCases = {
                "())",         // Output: 1
                "(((",         // Output: 3
                "()()",        // Output: 0
                "(()))(",      // Output: 2
                "",            // Output: 0
                "(()(()",      // Output: 2
                "())(()",      // Output: 2
        };

        for (String test : testCases) {
            int result = fixer.minAddToMakeValid(test);
            System.out.println("Input: \"" + test + "\" → Minimum Additions: " + result);
        }
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
