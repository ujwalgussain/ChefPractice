package a_practiceproblems.backtracking;

import java.util.ArrayList;

public class LetterCombinations {
    //https://www.interviewbit.com/problems/letter-phone/
    char[][] digits= new char[][] {
            {'0'},{'1'},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public ArrayList<String> letterCombinations(String A) {
        rec(A,0,new char[A.length()]);
        return result;
    }

    ArrayList<String> result = new ArrayList<>();
    public void rec(String A,int i, char[] ans){
        if(i==A.length()) {
            result.add(new String(ans));
            return;
        }
        char[] arr = digits[Integer.parseInt(A.charAt(i)+"")];
        for (char c: arr) {
            ans[i] = c;
            rec(A,i+1,ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

}
