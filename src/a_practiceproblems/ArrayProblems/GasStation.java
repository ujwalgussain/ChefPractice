package a_practiceproblems.ArrayProblems;

public class GasStation {
    //https://leetcode.com/problems/gas-station/
    //https://www.interviewbit.com/problems/gas-station/
    /*
        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3
        Explanation:
        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 4. Your tank = 4 - 1 + 5 = 8
        Travel to station 0. Your tank = 8 - 2 + 1 = 7
        Travel to station 1. Your tank = 7 - 3 + 2 = 6
        Travel to station 2. Your tank = 6 - 4 + 3 = 5
        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        Therefore, return 3 as the starting index.
    */
    //Simple Approach
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int n = A.length;
        if(n==1)
            return A[0]>=B[0]?0:-1;
        for(int i=0;i<n;i++)
        {
            int tank = 0;
            boolean empty=false;
            for(int s=i;s<n+i;s++)
            {
                int curr = s%n;
                tank+=(A[curr]-B[curr]);
                if(tank<0){
                    empty=true;
                    break;
                }
            }
            if(!empty)
                return i;

        }
        return -1;
    }

    //Optimal Approach:
    public int canCompleteCircuit1(final int[] A, final int[] B) {
        int ans = 0, cap = 0, total = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            cap += A[i] - B[i]; //store cap only if it is positive else 0
            if (cap < 0) {
                //i is not the answer...but i+1 can be
                ans = i + 1;
                total += cap; //total of A[i] - B[i] until now
                cap = 0;
            }
        }
        if (total + cap < 0) //if cap is +ve then store
            return -1;
        else
            return ans;
    }


}
