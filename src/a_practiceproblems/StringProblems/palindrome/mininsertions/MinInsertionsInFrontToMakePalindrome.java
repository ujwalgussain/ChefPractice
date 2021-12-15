package a_practiceproblems.StringProblems.palindrome.mininsertions;

public class MinInsertionsInFrontToMakePalindrome {
    //Logic: ans = length of str - length of longest palindromic substring from start
    //Ex: AAEC ans is EC
    class BruteForce{
        public int solve(String A) {
            int n = A.length();
            while(n>1 && !isPalindrome(A,n)){
                n--;
            }
            return A.length()-n;
        }
        public boolean isPalindrome(String A, int n) {
            int i=0, j=n-1;
            while(i<=j && A.charAt(i)==A.charAt(j))
            {
                i++;j--;
            }
            return i>j;
        }
    }
    class LPSApproach{
        public int solve(String A) {
            int strlen = A.length();
            A = A.concat("$").concat(new StringBuilder(A).reverse().toString());
            int j=0;
            int i=1;
            int n = A.length();
            int lps[] = new int[n];
            while(i<n){
                if(A.charAt(i)==A.charAt(j)){
                    lps[i++]=++j;
                }
                else{
                    if(j!=0) {
                        j=lps[j-1];
                    }
                    else{
                        lps[i]=0;
                        i++;
                    }
                }
            }
            return strlen-lps[n-1];
        }

    }

    public static void main(String[] args) {
        new MinInsertionsInFrontToMakePalindrome().new LPSApproach().solve("aaaa");
    }
}
