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

    //Approach 1: Linearly find a ceiling ie., 1st number y for which y*y>x
    // Then apply binSearch to search b/w y-1,y.
    static double findSqrt(int x){
        double i =1;
        while(i<=x){
            double sq = i*i;
            if(sq==x){
                return i;
            }
            else if(sq>x){
                //First number for which sq>x
                return findSqrt(x,i-1,i);
            }
            i++;
        }
        return -1;
    }

    //Approach 2: find a ceiling using BinSearch ie., 1st number y for which y*y>x
    // Then apply binSearch to search b/w y-1,y.
    static double findSqrtOptimized(int x) {
        double ceil = findCeiling(x);
        return findSqrt(x, ceil-1, ceil);
    }

    static double findCeiling(int x) {
        int lo = 1, hi = x/2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(mid*mid == x) {
                return mid;
            }
            if (mid * mid > x) {
                hi = mid;  // Found a candidate, look for smaller one
            } else {
                lo = mid + 1;  // Need bigger value
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(150));
        System.out.println(findSqrtOptimized(150));
    }
}
