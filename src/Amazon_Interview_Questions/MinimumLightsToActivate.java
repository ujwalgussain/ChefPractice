package Amazon_Interview_Questions;

public class MinimumLightsToActivate {
    /*https://www.interviewbit.com/problems/minimum-lights-to-activate/
 Problem Desc: https://www.interviewbit.com/problems/minimum-lights-to-activate/
There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
Initially all lights are off.
Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.

Input 1:
A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3

    * This problem can be solved by Greedy Approach.

Lets consider “curr” as the last light from left which is atleast covered by one of the tubelight. Initially curr = -1;
Then we iterate as follows:
For every curr position, we find the right most light in the range [ curr - B + 1, curr + B -1] and then update
the curr to be this light and repeat the process.

Bonus: Try solving it using Dp appraoch.*/
    public int solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int count = 0;
        while (i < n) {
            int j = Math.min(n - 1, i + B - 1);
            boolean b = false;
            while (j > (i - B + 1) && j >= 0 && j < n) {
                if (A[j] == 1) {
                    b = true;
                    i = j + B;
                    count++;
                    break;
                }
                j--;
            }
            if (!b)
                return -1;
        }
        return count;
    }

}
