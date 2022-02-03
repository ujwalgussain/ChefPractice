package a_practiceproblems.backtracking.subsetproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateSubsets {
    //------------------------GENERATE SORTED SUBSET--------------------------------------------//
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

    void generateSubsets(ArrayList<Integer> A, ArrayList<Integer> subset, int idx) {
        for (int i = idx; i < A.size(); i++) {
            subset.add(A.get(i));
            result.add(new ArrayList<>(subset));
            generateSubsets(A, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    //----------------------------------------------------------------------------------------------//


    //--------------------------APPROACH 2: --------------------------------------------------------//

    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(nums,0,new ArrayList<>());
        return subsets;
    }
    List<List<Integer>> subsets = new ArrayList<>();
    public void generateSubsets(int nums[],int idx, List<Integer> list){
        if(idx>=nums.length)
            subsets.add(new ArrayList<>(list));
        else{
            list.add(nums[idx]);
            generateSubsets(nums,idx+1,list);
            list.remove(list.size()-1);
            generateSubsets(nums,idx+1, list);
        }

    }


    //--------------------------------------Generate Subsets of Size K-----------------------------------------//


    //----------------------------------------Print subsets with target sum-------------------------------------//

    static List<String> answer = new ArrayList<>();
    static void printSubsets(int num[], int idx, int target, List<Integer> list) {

        for (int j = idx; j < num.length; j++) {
            if (target >= num[j]) {
                target = target - num[j];
                list.add(j);
                //System.out.println(list + " " + target);
                if (target == 0)
                    answer.add(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                printSubsets(num, j + 1, target, list);
                target = target + num[j];
                list.remove(list.size() - 1);
            }
        }

    }
    /*public static void main(String[] args) {
        printSubsets(new int[]{4, 2, 7, 1, 3}, 0, 10, new ArrayList<>());
        if (answer.size()==0)
            System.out.println("false");
        else
            System.out.println("true");
        answer.stream().sorted(Comparator.comparingInt(value -> value.length())).forEach(System.out::println);
    }*/
    //===========================================================================================================

    public static void main(String[] args) {
        System.out.println(new GenerateSubsets().subsets(new ArrayList<>(List.of(1,2,3))));
    }
}
