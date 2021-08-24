package a_practiceproblems.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindPermutationThatFormsNextGreatestNumber {

    //Link : https://www.interviewbit.com/problems/next-permutation/

    /*  1,2,3,4,5 -> All are in asc order...swap 4 5

        1,2,3,5,4 -> until 4 everything is in asc order but not the suffix

        1,2,4,3,5 -> ...but 354 becomes 435 [suffix changes]

    * */
    public static List<Integer> nextPermutation(List<Integer> A) {
        int k=-1,n=A.size();
        //k = last number in ascending order
        for(int i=0;i<n-1;i++)
        {
            if(A.get(i)<A.get(i+1))
                k=i;
        }
        System.out.println("k =" + k);
        //if A is in desc order then just sort
        if(k==-1)
        {
            Collections.sort(A);
            return A;
        }

        //l=last element greater than k
        int l = 0;
        for(int i=k+1;i<n;i++)
        {
            if(A.get(i)>A.get(k))
                l=i;
        }
        System.out.println("l =" + l);
        swap(A,k,l);

        //from k+1 to n-1 just swap in incr/decr to change position
        int j=k+1;
        int last =n-1;


        while(j<=last)
        {
            swap(A,j,last);
            j++;
            last--;
        }
        return A;
    }
    static void swap(List<Integer> A, int a, int b)
    {
        Integer temp = A.get(a);
        A.set(a,A.get(b));
        A.set(b,temp);
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation(Arrays.asList(1,8,3,5,7)));
    }
}
