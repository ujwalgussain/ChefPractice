package a_practiceproblems.backtracking.subsetproblems;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllSubsetsOfSize {
    //Ques: https://www.interviewbit.com/problems/combinations/
    public ArrayList<ArrayList<Integer>> combine(int a, int b) {
        ArrayList<Integer> A = IntStream.range(1,a+1).boxed().collect(Collectors.toCollection(ArrayList::new));
        generateSubsets(A,new ArrayList<>(),0,b);
        return result;
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> subset, int i, int b){
        if(i>=A.size()){
            if(subset.size()==b)
                result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(A.get(i));
        generateSubsets(A,subset,i+1,b);
        subset.remove(subset.size()-1);
        generateSubsets(A,subset,i+1,b);
    }
}
