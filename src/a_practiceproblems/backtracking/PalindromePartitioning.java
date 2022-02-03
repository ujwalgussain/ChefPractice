package a_practiceproblems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class PalindromePartitioning {
    class PalindromePartioning1{
        /*----------------Palindrome Substring 1-----------------------------------------*/
        //https://leetcode.com/problems/palindrome-partitioning/
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


    class PalindromicPartitioning2{
        //----------------------Palindromic Substring 2 : TLE--------------------------------------------------//
        public int minCutBFSApproach1(String s) { //starts here
            int n = s.length();
            LinkedList<Integer> idxList = new LinkedList<>();
            LinkedList<Integer> partitionCount = new LinkedList<>();
            idxList.add(-1); //empty string is palindrome
            partitionCount.add(0);
            while (!idxList.isEmpty()){
                int newStart = idxList.poll()+1; //string until idxList.poll() is already palindrome
                int currCount = partitionCount.poll();
                if(newStart==n)
                    return currCount-1;
                for (int i = newStart; i < n; i++) {
                    if(isPalindrome(s,newStart,i)){
                        idxList.add(i);
                        partitionCount.add(currCount+1);
                    }
                }
            }
            return -1;//code will never come here
        }

        HashMap<String, Boolean> map = new HashMap<>();
        public boolean isPalindrome(String s, int i, int j){
            String key = i+"+"+j;
            if(map.containsKey(key))
                return map.get(key);
            if(i==j)
                return true;
            while(i<=j){
                if(s.charAt(i++)!=s.charAt(j--)) {
                    map.put(key,false);
                    return false;
                }
            }
            map.put(key,true);
            return true;
        }

        //-----------------------------------Approach 2 : TLE----------------------------------------------------------------//
        //Using LongestPalindomic Substring Logic
        public int minCutBFSApproach2(String s) { //starts here
            int n = s.length();
            boolean[][] palindromeMap = new boolean[n][n];
            preProcess(s,palindromeMap);
            LinkedList<Integer> idxList = new LinkedList<>();
            LinkedList<Integer> partitionCount = new LinkedList<>();
            idxList.add(-1); //empty string is palindrome
            partitionCount.add(0);
            while (!idxList.isEmpty()){
                int newStart = idxList.poll()+1; //string until idxList.poll() is already palindrome
                int currCount = partitionCount.poll();
                if(newStart==n)
                    return currCount-1;
                for (int i = newStart; i < n; i++) {
                    if(/*isPalindrome(s,newStart,i)*/palindromeMap[newStart][i]){
                        idxList.add(i);
                        partitionCount.add(currCount+1);
                    }
                }
            }
            return -1;//code will never come here
        }
        public void preProcess(String s, boolean[][] palindromeMap){
            char c[] = s.toCharArray();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if(i==j)
                        palindromeMap[j][i] = true;
                    else{
                        if(c[i]==c[j]){
                            if(i==j+1 || i+1==j)
                                palindromeMap[j][i] = true;
                            else{
                                palindromeMap[j][i] = palindromeMap[j+1][i-1];
                            }
                        }
                    }
                }
            }
        }
    }
}
