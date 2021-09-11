package a_practiceproblems.ArrayProblems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedList{
    /*
    * Logic :
    * We take the last occurence of element as eligible ie., when A[i]!=A[i-1]
    * Let curr represent the index for copying the eligble elements
    * Now when eligible the put it in curr index and increment curr.
    * last element in the array is guaranteed to be eligible hence add.
    * */

    int removeDuplicates(int arr[], int n)
    {
        if (n==0 || n==1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i=0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];

        arr[j++] = arr[n-1];
        System.out.println(Arrays.toString(arr));
        return j;
    }

    /*
     * Logic :
     * We take the last two occurence of element as eligible ie., when A[i]!=A[i-1] -> last occurence or A[i] != A[i+2] -> second last element
     * Let curr represent the index for copying the eligble elements
     * Now when eligible the put it in curr index and increment curr.
     * last element in the array is guaranteed to be eligible hence add.
     * */

    public int removeDuplicatesWithMoreThanTwoOccurences(int[] A) {
        int n = A.length;
        if(n==0 || n==1)
            return n;

        int curr=0;
        for(int i=0;i<n-2;i++)
        {
            if(A[i] !=A[i+1] || A[i] != A[i+2])
                A[curr++] = A[i];
        }
        A[curr++] = A[n-2];
        A[curr++] = A[n-1];
        return curr;
    }
}
