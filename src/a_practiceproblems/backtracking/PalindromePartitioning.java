package a_practiceproblems.backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String a) {
        generate(a,new ArrayList<>(),0);
        return result;
    }
    public boolean isPalindrome(String str, int start, int end){
        if(start == end)
            return true;
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--))
                return false;
        }
        return true;
    }
    public void generate(String a, ArrayList<String> solution, int idx){
        if(idx==a.length()) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for(int i=idx;i<a.length();i++){
            if(isPalindrome(a,idx,i)){
                solution.add(a.substring(idx,i+1));
                generate(a,solution,i+1);
                solution.remove(solution.size()-1);
            }
        }
    }
}
