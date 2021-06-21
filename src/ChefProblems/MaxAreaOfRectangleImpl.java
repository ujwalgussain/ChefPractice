package ChefProblems;

import java.util.Arrays;

import static java.lang.Math.max;

public class MaxAreaOfRectangleImpl {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return
                 mod(findMaxDiff(horizontalCuts,h)
                        , findMaxDiff(verticalCuts,w),
                         ((int)Math.pow(10,9))+7);
    }

    static int mod(int a, int b,
                       int mod)
    {
        int res = 0; // Initialize result
        a = a % mod;
        while (b > 0)
        {
            // If b is odd, add 'a' to result
            if (b % 2 == 1)
            {
                res = (res + a) % mod;
            }

            // Multiply 'a' with 2
            a = (a * 2) % mod;

            // Divide b by 2
            b /= 2;
        }

        // Return result
        return res % mod;
    }
    public int findMaxDiff(int[] arr, int len)
    {
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i]-arr[i-1],max);
        }
        int ans= Math.max(max,len-arr[arr.length-1]);
        System.out.println(ans);
        ans%=(((int)Math.pow(10,9))+7);
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfRectangleImpl().maxArea(
                1000000000,
                1000000000,
                new int[]{2},
                new int[]{2}
                ));
    }
}
