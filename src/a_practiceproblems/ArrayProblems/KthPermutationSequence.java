package a_practiceproblems.ArrayProblems;

import java.util.LinkedList;

public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        //https://www.youtube.com/watch?v=wT7gcXLYoao - take U forward - L18. K-th Permutation Sequence | Leetcode
        int factArr[] = new int[n+1];
        LinkedList<Integer> numbers = new LinkedList<>();
        factArr[0]=1;
        int fact = 1;
        for (int i = 1; i <= 11; i++) {
            fact*=i;
            factArr[i] = fact;
            numbers.add(i);
        }
        for (int i = 12; i <=n ; i++) {
            factArr[i] = Integer.MAX_VALUE;
            numbers.add(i);
        }
        k--; //Zero Base Idx
        StringBuilder answer = new StringBuilder();
        while(!numbers.isEmpty()){
            int currFact = factArr[numbers.size()-1];
            int idx = k/currFact;
            answer.append(numbers.get(idx));
            numbers.remove(numbers.get(idx));
            k%=currFact;
        }
        return answer.toString();
    }
}
