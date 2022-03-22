package a_practiceproblems.ArrayProblems;

import a_practiceproblems.TestClass3;

public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositiveInteger().firstMissingPositive(new int[]{1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        /*
        https://leetcode.com/problems/first-missing-positive/submissions/
        https://www.youtube.com/watch?v=-lfHWWMmXXM
        * Here the idea is to place every no i at ith index
        * A. For every element nums
        *   If nums[i] is -ve then go to next number
        *   If nums[i] is greater than len then go to next number
        *   If nums[i] is in range of 1 to len
        *       if nums[i] != i and nums[nums[i]] != nums[i] ie., i doesnt have correct element
        *           swap and repeat the step A
        *       else
        *           i++
        *
        * Ex 1:
        *   idx   1 2  3 4
        *   nums  3 4 1 -1
        * When i=1, place 3 at 3 idx
        *   idx      1 2  3  4
         *  nums     1 4  3 -1
         *      since nums[0] =1 is at proper place increment i
         * When i=2, place 4 at 4 idx
         *  idx      1  2  3  4
         *  nums     1  -1 3  4
         *      since nums[0] =-1 increment i
         * When i=3, 3 is at proper place increment i
         * When i=3, 4   is at proper place increment i
        *   Now idx 2 has incorrect number hence ans is 2
        * Ex 2:
        * idx    1
        * nums   1
        * In this case 1 is at proper place and no need to rearrange hence ans is len +1 ie., 2
        *
        * Ex: 3
        * idx  1 2
        * nums 1 1
        * For i=2 nums[1] already has 1 so dont swap...and hence ans is 2
        * */
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (
                    nums[i] > 0 && nums[i] <= len //nums[i] in range of 1 to len
                            && nums[nums[i]-1]!=nums[i] //nums[i] not at i-1 idx
            ) {
                int correctPos = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < len; j++) {
            if (nums[j] - 1 != j)
                return j + 1;
        }
        return len + 1;
    }
}
