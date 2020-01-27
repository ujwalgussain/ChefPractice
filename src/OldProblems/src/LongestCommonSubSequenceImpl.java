package OldProblems.src;

public class LongestCommonSubSequenceImpl {
    static int LCS_topDown(String p,String q, int m, int n)
    {
        if(m==-1 || n==-1)
            return 0;
        if(p.charAt(m)==q.charAt(n))
            return 1+LCS_topDown(p,q,m-1,n-1);
        return Math.max(LCS_topDown(p,q,m-1,n),LCS_topDown(p,q,m,n-1));
    }

    static String LCS_topDown_withString(String p,String q, int m, int n)
    {
        if(m==-1 || n==-1)
            return "";
        if(p.charAt(m)==q.charAt(n))
            return LCS_topDown_withString(p,q,m-1,n-1).concat(p.charAt(m)+"");
        String s1 = LCS_topDown_withString(p,q,m-1,n);
        String s2 = LCS_topDown_withString(p,q,m,n-1);
        if(s1.length()>s2.length())
        {
            return s1;
        }
        {
            return s2;
        }
    }

    public static void main(String args[])
    {
        String p = "AABBAABBCC", q="ACABB";
        System.out.println(LCS_topDown(p,q,p.length()-1,q.length()-1));
        System.out.println(LCS_topDown_withString(p,q,p.length()-1,q.length()-1));
    }
}
