package Dynamic_Programming;

import java.util.Arrays;

public class MinJumps {
    //https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-jumps-re-official/ojquestion
    public static void solve(int arr[]){
        // write your code here
        int n = arr.length;
        int dp[] = new int[n];
        dp[n-1] = 0; //final destination
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i]==0){
                dp[i] = Integer.MAX_VALUE; // we cant move forward
                continue;
            }
            int maxJumpPt = Math.min(i+arr[i],n-1); //shouldnt go out of range
            int minJumpsUptoI=Integer.MAX_VALUE;
            for (int j = i+1; j <= maxJumpPt; j++) {
                minJumpsUptoI = Math.min(minJumpsUptoI,dp[j]);
            }
            if(minJumpsUptoI==Integer.MAX_VALUE) //cant reach end from i
                dp[i] = minJumpsUptoI;
            else
                dp[i] = minJumpsUptoI+1;
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        solve(new int[]{3,3,0,2,1,2,4,2,0,0});
    }
}
