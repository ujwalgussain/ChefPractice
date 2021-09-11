package a_practiceproblems.StringProblems.palindrome;

public class LongestPalindromicSubString {
    /*static int startSub=-1;
    static int endSub =-1;
    static int maxLength=0;

    public static int helper(char[] str, int start, int end)
    {
        if(start>=end)
            return 1;
        if(str[start] == str[end]) {
            int ans =  2 + helper(str, start + 1, end - 1);
            if(ans>maxLength)
            {
                startSub = start;
                endSub = end;
                maxLength = ans;
            }
            return ans;
        }
        return Math.max(helper(str,start+1,end),helper(str,start,end-1));
    }*/

    static String dp(String s)
    {
        int n = s.length();
        if(n==1)
            return s;
        boolean dp[][] = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        int startSub=0,endSub=0,maxLength=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                //If both chars match
                if(s.charAt(i) == s.charAt(j)) {
                    //If both chars are adjacent to each other then
                    if(Math.abs(i-j) == 1)
                    {
                        dp[j][i] = true;
                    }
                    else
                    {
                        //This means that it is possible that
                        // the whole string starting from idx j to i is palindrome
                        //only if j+1 to i-1 is palindrome
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                    if(dp[j][i])
                    {
                        int len = i-j+1;
                        if(len>maxLength)
                        {
                            startSub = j;
                            endSub = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }
        return s.substring(startSub,endSub+1);
    }

    public static void main(String[] args) {

        System.out.println(dp("cbbd"));
    }
    /*Test Cases:
    * 1. babad - bab/aba
    * 2. ab
    * 3. aa
    * 4. a
    * 5. aababcaa- aba/bab*/

}
