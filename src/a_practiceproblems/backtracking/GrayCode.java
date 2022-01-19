package a_practiceproblems.backtracking;

import java.util.ArrayList;

public class GrayCode {
    //Ques: https://www.interviewbit.com/problems/gray-code/
    //https://www.geeksforgeeks.org/backtracking-approach-generate-n-bit-gray-codes/
    /*
	Ex:  n = 2 ->
	f(2)
    {
        f(1)
        {
            f(0)
            {
                add(0);         [0]
            }
            num = 0^1 = 1
            f(0)
            {
                add(1)          [0,1]
            }
        }
        num = 1^2 = 3
        f(1)
        {
            f(0)
            {
                add(3);         [0,1,3]
            }
            num=3^1=2
            f(0)
            {
                add(2)          [0,1,3,2]
            }
        }
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
