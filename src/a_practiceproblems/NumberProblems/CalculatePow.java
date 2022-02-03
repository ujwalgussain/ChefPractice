package a_practiceproblems.NumberProblems;

public class CalculatePow {
    public double myPow(double x, int n) {
        //https://www.youtube.com/watch?v=l0YC3876qxg - take U forward - POW(x,n) | Binary Exponentiation | Leetcode

        double ans = 1;
        long pow = n; //To handle Integer.MIN_VALUE
        pow = Math.abs(pow);
        while(pow>0){
            if((pow&1)==0){
                x=x*x;
                pow>>=1;
            }
            else{
                ans*=x;
                pow--; //now pow will be even
            }
        }
        return n<0?1/ans:ans;
    }
}
