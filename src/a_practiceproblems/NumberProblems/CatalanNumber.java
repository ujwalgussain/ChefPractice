package a_practiceproblems.NumberProblems;

public class CatalanNumber {
    /*
    Catalan Number :
    c0 - 1
    c1 - 1
    c2  - c0*c1
    c3 - c0*c3 + c1*c2 + c2*c1 + c3*c0
     */
    int catalan(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CatalanNumber().catalan(5));

    }
}
