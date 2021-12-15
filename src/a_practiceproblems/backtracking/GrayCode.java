package a_practiceproblems.backtracking;

import java.util.ArrayList;

public class GrayCode {
    //Ques: https://www.interviewbit.com/problems/gray-code/
    //https://www.geeksforgeeks.org/backtracking-approach-generate-n-bit-gray-codes/
    /*
	Ex:  n = 2 ->
	n=2 num=0
		n=1 num=0
			n=0 num=0
				add(0) return
			update num
			n=0 num=1
				add(1) return
			update num
		n=1 num=3
			n=0 num=3
				add(3) return
			update num
			n=0 num=2
				add(2) return

	*/
    int num=0;
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        generate(result,a);
        return result;
    }
    public void generate(ArrayList<Integer> result, int n){
        if(n==0){
            result.add(num);
        }
        else{
            generate(result,n-1);
            num = num ^ (1<<(n-1));
            generate(result,n-1);
        }
    }
}
