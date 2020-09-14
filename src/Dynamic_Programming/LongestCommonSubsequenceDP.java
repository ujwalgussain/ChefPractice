package Dynamic_Programming;

import java.util.Arrays;

public class LongestCommonSubsequenceDP {
    /*
    * Create a 2D Matrix as shown below
    *           a b c d e f
    *         0 0 0 0 0 0 0
    *       a 0
    *       b 0
    *       c 0
    *       b 0
    *       f 0
    * the ans will be entry[maxrow][maxcol]
    * if(str1[i-1]==str2[j-1])
    *   ans is 1 + \ diagonal left up
    * else
    *   ans is max of up and left
    * */

    static void LCS(char[] str1, char[] str2, int n, int m)
    {
        int table[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                if(str1[i-1]==str2[j-1])
                {
                    System.out.println("matched");
                    table[i][j]= 1+table[i-1][j-1];
                }
                else
                {
                    table[i][j]= Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        for (int i=0;i< table.length;i++)
            System.out.println(Arrays.toString(table[i]));
        System.out.println(table[n][m]);
    }

    public static void main(String[] args) {
        LCS("abcdaf".toCharArray(),"acbcf".toCharArray(),6,5);
    }
}
