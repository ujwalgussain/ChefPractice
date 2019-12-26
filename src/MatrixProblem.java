import java.util.Arrays;
import java.util.Scanner;

public class MatrixProblem {
    public static void transform(int arr[][], int x, int y)
    {
        for(int i=0;i<arr[x].length;i++) {
            arr[x][i] += 1;
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i][y]+=1;
        }
    }
    public static void solve(int n, int m,int[] transform)
    {
        int i=-2;
        int[][] arr = new int[n][m];
        while((i+=2)<transform.length){
            transform(arr,transform[i]-1,transform[i+1]-1);
        }
    }
    public static int countOdds(int arr[][])
    {
        int count=0;
         for(int i =0;i<arr.length;i++)
         {
             for(int j=0; j<arr[0].length;j++)
             {
                 if (arr[i][j]%2==0)
                     count++;
             }
         }
         return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i=0;i<testcase;i++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            int arr[][] = new int[n][m];
            display(arr);
            for(int j=0;j<q;j++)
            {
                transform(arr,sc.nextInt()-1,sc.nextInt()-1);
                display(arr);
            }
            System.out.println(countOdds(arr));
        }
    }
    public static void display(int[][] arr)
    {
        for(int i =0;i<arr.length;i++)
        {
            for(int j=0; j<arr[0].length;j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
