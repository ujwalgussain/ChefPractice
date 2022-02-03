package a_practiceproblems.ArrayProblems.binarySearch;

public class FindSqrt {
    static double findSqrt(double x, double lo, double hi){
        while(true){
            double mid = (lo+hi)/2d;
            double sq = mid*mid;
            if(sq==x || Math.abs(sq-x)<0.00001)
                return mid;
            if(sq<x)
                lo=mid;
            else
                hi=mid;
        }
    }
    static double findSqrt(int x){
        double i =1;
        while(i<=x){
            double sq = i*i;
            if(sq==x){
                return i;
            }
            else if(sq>x){
                return findSqrt(x,i-1,i);
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(5));
    }
}
