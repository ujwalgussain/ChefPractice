package a_practiceproblems.StringProblems.palindrome;

import utils.ArrayUtils;

import java.util.Arrays;
//https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
public class CountMinSwapsToMakePalindromeImpl {
    public static int solve(String s)
    {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int count=0;
        for(int i = 0; i<n/2; i++)
        {
            int right = n-i-1;
            while(i<right)
            {
                if(arr[i] == arr[right])
                    break;
                right--;
            }
            if(i==right)
                return -1;
            else
                if(arr[i] != arr[n-i-1])
                {
                    ArrayUtils.swap(arr,right,n-i-1);
                    count++;
                }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solve("mamad"));
    }
}
