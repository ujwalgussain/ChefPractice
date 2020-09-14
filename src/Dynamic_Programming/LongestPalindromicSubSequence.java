package Dynamic_Programming;

import com.sun.javafx.image.BytePixelSetter;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
    /*
    * */
    static void calculateLongestPalindromicSubstring(char[] str,int N)
    {
        int[][] table = new int[N][N];
        int max= Integer.MIN_VALUE;
        for(int col=0;col<N;col++)
        {
            for (int row = 0; row <=col; row++) {
                System.out.printf("[%d,%d]\n",row,col);
                int ans=1;
                if(row==col)
                {
                    table[row][col]=1;
                }
                else
                {
                    if(str[row]==str[col])
                    {
                        if(col-1==row) {
                            System.out.printf("\t2 chars[%c,%c]\n",str[row],str[col]);
                            table[row][col] = 1;
                            ans = 2;
                        }
                        else {
                            if(row+1==col-1 || table[row+1][col-1] == 1)
                            {
                                table[row][col] = 1;
                                ans=(col-row)+1;
                            }
                        }
                    }
                }
                if(ans>1)
                    System.out.println("Palindrome len="+ ans+" str = " + Arrays.toString(Arrays.copyOfRange(str,row,col+1)));
                max = Math.max(max,ans);
            }
        }
        System.out.println("MAX " + max);
    }

    static void findNumberOfPalindromicSubstring(char[] str,int N)
    {
        int[][] table = new int[N][N];
        int count=0;
        for(int col=0;col<N;col++)
        {
            for (int row = 0; row <=col; row++) {
                System.out.printf("[%d,%d]\n",row,col);
                if(row==col)
                {
                    table[row][col]=1;
                    count++;
                }
                else
                {
                    if(str[row]==str[col])
                    {
                        if(col-1==row) {
                            table[row][col] = 1;
                            count++;
                        }
                        else {
                            if(row+1==col-1 || table[row+1][col-1] == 1)
                            {
                                table[row][col] = 1;
                                count++;
                            }
                        }
                    }
                }

            }
        }
        System.out.println("No of Palindromic Substrings is "+count);
    }

    static void printAllPalindromicSubstring(char[] str,int N)
    {
        int[][] table = new int[N][N];
        int count=0;
        for(int col=0;col<N;col++)
        {
            for (int row = 0; row <=col; row++) {
                if(row==col)
                {
                    table[row][col]=1;
                    count++;
                }
                else
                {
                    if(str[row]==str[col])
                    {
                        if(col-1==row) {
                            table[row][col] = 1;
                            count++;
                            System.out.println("Found " + Arrays.toString(Arrays.copyOfRange(str,row,col+1)));
                        }
                        else {
                            if(row+1==col-1 || table[row+1][col-1] == 1)
                            {
                                table[row][col] = 1;
                                count++;
                                System.out.println("Found " + Arrays.toString(Arrays.copyOfRange(str,row,col+1)));
                            }
                        }
                    }
                }

            }
        }
        System.out.println("No of Palindromic Substrings is "+count);
    }



    public static void main(String[] args) {
        calculateLongestPalindromicSubstring("ababaf".toCharArray(),5);
        findNumberOfPalindromicSubstring("ababaf".toCharArray(),5);
        printAllPalindromicSubstring("ababaf".toCharArray(),5);
    }
}
