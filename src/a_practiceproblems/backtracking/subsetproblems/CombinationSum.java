package a_practiceproblems.backtracking.subsetproblems;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    //Ques: https://www.interviewbit.com/problems/combination-sum/
    /*
    Here the difficult part is to maintain order and avoid duplicates.
    Order - sort input List
    Duplicates - avoid recalculations for if A.get(i) == A.get(i-1)
    */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        generateSubsets(A,new ArrayList<>(),0,B);
        return result;
    }

    void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> subset, int i, int total){
        if (i == A.size()) {
            if (total == 0)
                result.add(new ArrayList<>(subset));
            return;
        }
        if(i > 0 && A.get(i) == A.get(i-1)){ //This has already been calculated
            generateSubsets(A, subset, i + 1, total);
            return;
        }
        if (A.get(i)<= total) {
            subset.add(A.get(i));
            //Add current element to set and call for curr element again
            generateSubsets(A, subset, i,total-A.get(i));

            subset.remove(subset.size() - 1);

        }
        //call for next element.
        generateSubsets(A,subset,i+1, total);

    }
}
