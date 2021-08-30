package a_practiceproblems.ArrayProblems.pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class PairsWithGivenDiff {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<A.size();i++)
        {
            if(set.contains(A.get(i)-B))
                return 1;
            if(set.contains(A.get(i)+B))
                return 1;
            set.add(A.get(i));
        }
        return 0;
    }
}
