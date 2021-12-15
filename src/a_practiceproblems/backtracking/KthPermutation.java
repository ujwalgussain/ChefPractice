package a_practiceproblems.backtracking;

import java.util.ArrayList;

public class KthPermutation {
    //Ques:https://www.interviewbit.com/problems/kth-permutation-sequence/
    //Youtube : //https://www.youtube.com/watch?v=wT7gcXLYoao
    public static void main(String[] args) {

        System.out.println(new KthPermutation().getPermutation(4,17));
    }
    public String getPermutation(int A, int B) {
        ArrayList<String> list = new ArrayList<>();
        //This array is used to store factorial to avoid recalculation.
        ArrayList<Integer> factList = new ArrayList<>();
        factList.add(1);//0!=1
        int fact = 1;
        for (int i = 1; i<=11 && i <= A ; i++) {
            fact*=i;
            factList.add(fact);
            list.add(String.valueOf(i));
        }
        //We are adding INF for fact(i) if i >11
        if(B>12)
            for (int i = 12; i <= A; i++) {
                factList.add(Integer.MAX_VALUE);
                list.add(String.valueOf(i));
            }
        //corner case
        if(B>factList.get(A))
            return "";
        B--; //As we are using Oth based index for permutations
        StringBuilder ans = new StringBuilder();
        while(!list.isEmpty()){
            fact=factList.get(list.size()-1);
            //Get the current digit
            int selectedIdx = B/fact;
            ans.append(list.get(selectedIdx));
            list.remove(selectedIdx);
            //reset B
            B=B%fact;
        }
        return ans.toString();
    }
    /*
Note: No of possible permutations are n!.
Hence each digit will appear n-1 times at each position.

Ex: 1,2,3,4 and if we go in ascending order then and K =17 for Oth based index K= 16
	idx 0   1...3
		1 + [2,3,4]-> 3! = 6 ie., permutations 0-5
		2 + [1,3,4]-> 3! = 6 ie., permutations 6-12
		3 + [1,2,4]-> 3! = 6 ie., permutations 13-18 ---> 16 th permutation lies here..!!
		4 + [1,2,3]-> 3! = 6 ie., permutations 19-24

		First digit of Kth permutation is 3
		Similarly
		We need to apply same process for [1,2,4] and K = K%3! = 16%6=4

		0	1	2..3
		3 +	1 + [2,4]-> 2!
			2 + [1,4]-> 2!
			4 + [1,2]-> 2! permutations 4-5 ..4th permutation lies here ...!!
		Second digit of Kth permutation is 4


Answer will be 3412
    */
}
