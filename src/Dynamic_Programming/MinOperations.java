package Dynamic_Programming;

public class MinOperations {
    //Logic Link : https://drive.google.com/file/d/1RJNdXqR9vvcdp4pSpMkrgeJtuWigGZoO/view?usp=sharing
    /*
    * since we can either double or add 1 to any number
    * if n is even, best way to reach ans(n) will be ans(n/2)+1
    * hence, if n is odd then best way will be ans(n-1) + 1 as n-1 will be even for which already we will have the best way
    * */
    public int minOperation(int n) {
        /*
                            2+1=3
                1+1=2     /
               /     \   /
       0+1 = 1          2
               \     /    \
                1*2=2      \
                            2*2=4

         */
        if (n <= 3)
            return n;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            if (isEven(i)) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[n];
    }

    public static boolean isEven(int i)
    {
        return (i & 1) == 0;
    }

}
