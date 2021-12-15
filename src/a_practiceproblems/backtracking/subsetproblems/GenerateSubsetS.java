package a_practiceproblems.backtracking.subsetproblems;

import java.util.ArrayList;
import java.util.Collections;

public class GenerateSubsetS {
    class GenerateSortedSubset{
        //Ques: https://www.interviewbit.com/problems/subset/
        /*If S = [1,2,3], a solution is:
            [
              [],
              [1],
              [1, 2],
              [1, 2, 3],
              [1, 3],
              [2],
              [2, 3],
              [3],
            ]
        */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            Collections.sort(A);
            result.add(new ArrayList<>());
            generateSubsets(A, new ArrayList<>(), 0);
            return result;
        }

        void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> subset, int idx){
            for (int i = idx; i < A.size(); i++) {
                subset.add(A.get(i));
                result.add(new ArrayList<>(subset));
                generateSubsets(A,subset,i+1);
                subset.remove(subset.size()-1);
            }
        }
    }

    class GenerateSubsets{

    }
}
