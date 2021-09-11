package Dynamic_Programming.udemy;

public class ClimbingStairs {
    /*
    n=1 -> 	1 step

    n=2 ->	1 step + 1 step
            2 step

    n=3 ->	1 step + 1 step + 1 step  [n=2] + 1 step
            2 step + 1 step

            1 step + 2 step [n=1] +  2 step

    n= 4 -> 1 step + 1 step + 1 step + 1 step [n=3] + 1 step
            2 step + 1 step + 1 step
            1 step + 2 step + 1 step

            1 step + 1 step + 2 step [n=2] + 2 step
            2 step + 2 step
    * */
    /*
    Ques 1: As there were many ways to reach heaven, many people walked up this staircase to the heaven.
    But some people were mean and didn't want more people to reach heaven so they spilled oil on some stairs
    so that no one could step on that stair.
    For example, suppose there are only 5 steps on that staircase and stair no. 3 has oil spilled on it.
    Then in how many ways can you reach heaven now?
    Possibilities are:- (1,1,2,1) and (2,2,1).
                0   1   2   3   4   5
    ways[] -> [ 1,  1,  2,  0,  2,  2]
                            ^
        since oil is spilled on step 3

    similarly,

Question 2:
 Following the previous problem.
 Now, suppose there are only 5 steps on that staircase and stair no. 2 and stair no. 4 have oil spilled on it.
 Then in how many ways can you reach heaven now? (1,2,2) is the only possibility.
                0   1   2   3   4   5
    ways[] -> [ 1,  1,  0,  1,  0,  1]
                            ^
        since oil is spilled on step 2 and 3

    */

    public int climbStairs(int n) {
        int n1 = 1, n2 = 1;
        int ans = 0;
        if(n<=1)
            return n1;
        for(int i=2;i<=n;i++)
        {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }
}
