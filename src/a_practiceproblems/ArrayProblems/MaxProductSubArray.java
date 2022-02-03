package a_practiceproblems.ArrayProblems;

import a_practiceproblems.TestClass3;

public class MaxProductSubArray {
/*
0, -3, 4, -10, -1, -6, 0, 8, -8, -6, -5, -5, 0, -3, -9, 1, 5, -8, 0, 6, 1, -6, -8, 3, 0, -8, -9, 6, 8, 5

Case 1: All +ves -> whole array
Case 2: All -ves ->
		if(even no of -ves)
			then ans will be +ve
		else
			ans will be obtained by removing one -ve element and trying to get max Product
Case 3: If one of 0
		If all 0's
				ans will be 0
		else
			max of left_subarray, right_sub_array

Solution 1:
	for(i = 0 to n)
		for(j = i to n)
			prod *= a[i]
			ans = max(ans, prod)
			if(prod==0)
				continue outer loop

Solution 2:
	min=max=ans=A[0]
	for i = 1 to n
		if(A[i] is -ve)
			swap min,max because after mul the sign will be changed
		max = max(A[i],max*A[i])
		min = min(A[i],min*A[i])
		if(ans<max)
			ans = max

* */

    public static int find(int A[]) {

        int max_upto = A[0], min_upto = A[0];
        int maxProd = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                //swap
                int temp = max_upto;
                max_upto = min_upto;
                min_upto = temp;
            }
            min_upto = Math.min(min_upto * A[i], A[i]);
            max_upto = Math.max(max_upto * A[i], A[i]);
            if (max_upto > maxProd)
                maxProd = max_upto;
        }
        return maxProd;
    }

}
