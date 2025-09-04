package com.tanmoy.questions.q6;

public class Solution {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int test1 = 19;
        int test2 = 2;

        System.out.println("Is " + test1 + " a happy number? " + solution.isHappy(test1)); // true
        System.out.println("Is " + test2 + " a happy number? " + solution.isHappy(test2)); // false
    }
}
