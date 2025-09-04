package com.questions.q4;

import java.util.Stack;

public class ValidParent {

    public static void main(String[] args) {
        ValidParent validator = new ValidParent();

        String[] testCases = {
                "()",        // true
                "()[]{}",    // true
                "(]",        // false
                "([)]",      // false
                "{[]}",      // true
                "((({{{[[[]]]}}})))", // true
                "(",         // false
                ""           // true
        };

        for (String test : testCases) {
            boolean result = validator.isValid(test);
            System.out.println("Input: " + test + " → Valid: " + result);
        }
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if (ch == ')'){
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if (ch == '}'){
                    if (stack.isEmpty() || stack.pop() != '{' ){
                        return false;
                    }
                }
                if (ch == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
