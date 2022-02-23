package a_practiceproblems.StringProblems.palindrome;

import utils.ArrayUtils;

import java.util.Arrays;
//https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
public class CountMinAdjSwapsToMakePalindromeImpl {
    public static int solve(String s)
    {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int count=0;
        boolean invalidCharFound = false;
        boolean isOddLen = (n&1)==1;
        for(int i = 0; i<n/2; i++)
        {
            int right = n-i-1;
            //find the next occurence of arr[i]
            while(i<right)
            {
                if(arr[i] == arr[right])
                    break;
                right--;
            }
            //We have parsed until mid of string
            if(i==right){
                if(isOddLen && !invalidCharFound){
                    invalidCharFound = true;
                    while(i<n/2-1){
                        ArrayUtils.swap(arr,i,i+1);
                    }
                }
            }
            else
                if(arr[i] != arr[n-i-1])
                {
                    System.out.println("Swap "+arr[right] + " " + arr[n-i-1]);
                    ArrayUtils.swap(arr,right,n-i-1);
                    System.out.println("After Swapping " + String.valueOf(arr));
                    count++;
                }
        }
        return count;
    }
    public static void main(String[] args) {
        /*
        Ex: s = "mamda"
        For i=0-> right will stop at 2
           Swap m a   -> After Swapping s = maadm
        For i=1 -> right will stop at 2
           Swap a d -> After Swapping s = madam
        2
         */

        System.out.println(solve("dmama")); //will re
    }


}
