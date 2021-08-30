package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;

public class A_MinSubArrayWithSumGreaterThanEqualToK {
    /*Algo:
    1. Fix Start, End At 0
    2. Move End from 0 to N
            sum = sum + A[i]
            until sum >= K
                calculate len of array from start to end
                check if len < min len and update min len
                remove element at start pos from sum
                    ie., sum-=A[start++]
    * */
    public static int findLength(int A[], int K) {
        // This wont work as above algo doesnt work with negatives
        int N = A.length;
        if (N == 0)
            return 0;
        int left = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            sum += A[right];
            //cannot be if condition
            //Ex : K=100 Window = 13 17 20 50
            //17 20 50 = 87
            //20 50 = 70
            //50 = 50
            while (sum >= K) {
                ans = Math.min(ans, right + 1 - left);
                sum -= A[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int findMinLengthWithNegatives(int[] nums, int k)
    {
        /** nums = {84, -37, 32, 40, 95}            k = 167
         * PreSum=  0,  84,  47, 79, 119, 214]
         * Ex:
         * i=0 queue=[]
         * i=1 queue=[0]
         * i=2 queue=[0, 1]
         * Remove last as preSums[1]ie{84}>= preSums[2]ie{47}
         * i=3 queue=[0, 2]
         * i=4 queue=[0, 2, 3]
         * i=5 queue=[0, 2, 3, 4]
         * 0 to 5 sum=214
         * 2 to 5 sum=167
         * 3
         */
        int len = nums.length;

        int[] preSums = new int[len+1];

        preSums[0] = 0;

        for (int i = 0; i < len; ++i)
            preSums[i+1] = preSums[i] + nums[i];

        System.out.println("PreSum" + Arrays.toString(preSums));

        int res = len + 1;

        //This will keep track of only +ve elems so when we move right we move from one +ve to next +ve
        //1st while loop will remove all -ves

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= len; ++i) {
            System.out.println(String.format("i=%s queue=%s",i,queue));
            //Remove until pre_sum of previous element is greater than curr_elem [this will happen only for negatives]
            while (!queue.isEmpty() && preSums[queue.peekLast()] >= preSums[i]) {
                System.out.println(String.format("Remove last as preSums[%s]ie{%s}>= preSums[%s]ie{%s}",
                        queue.peekLast(),
                        preSums[queue.peekLast()] ,
                        i,
                        preSums[i]));
                queue.pollLast();
            }

            while (!queue.isEmpty() && (preSums[i] - preSums[queue.peek()]) >= k) {
                System.out.println(String.format("%s to %s sum=%s", queue.peek(),i,preSums[i] - preSums[queue.peek()]));
                res = Math.min(res, i - queue.poll());
            }

            queue.add(i);
        }
        return res == len+1 ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(findMinLengthWithNegatives(new int[]{2,-1,2},3));
        //System.out.println(findMinLengthWithNegatives(new int[]{84,-37,32,40,95},167));
    }
}
