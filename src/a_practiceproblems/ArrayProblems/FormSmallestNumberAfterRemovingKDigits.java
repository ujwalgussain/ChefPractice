package a_practiceproblems.ArrayProblems;

import java.util.Stack;

public class FormSmallestNumberAfterRemovingKDigits {
    //https://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
    public static String removeKdigits(String num, int k)
    {
        StringBuilder result = new StringBuilder();

        // We have to delete all digits
        if (k >= num.length()) {
            return "0";
        }
        // Nothing to delete
        if (k == 0) {
            return num;
        }
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            System.out.printf("Current Char-%s k=%s %n Stack=%s %n",c,k,s);
            // Removing all digits in stack that are greater
            // than this digit(since they have higher
            // weightage)
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                System.out.println("pop and k--");
                s.pop();
                k--;
            }
            // ignore pushing 0
            if (!s.isEmpty() || c != '0') {
                System.out.println("Push c");
                s.push(c);
            }
        }

        // If our k isnt 0 yet then we keep popping out the
        // stack until k becomes 0
        //Ex : num "1234567" k=5
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String str = result.reverse().toString();

        return str;
    }
    // Driver Code
    public static void main(String[] args)
    {
        String s = "4325043"; //2043
        int k = 3;
        System.out.println(removeKdigits(s, k));

        s = "789654321"; //654321
        k = 5;
        System.out.println(removeKdigits(s, k));
    }
}
