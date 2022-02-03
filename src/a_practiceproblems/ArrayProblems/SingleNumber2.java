package a_practiceproblems.ArrayProblems;

public class SingleNumber2 {
    //https://leetcode.com/problems/single-number-ii/
    //https://www.youtube.com/watch?v=cOFAmaMBVps
    public int singleNumber(int[] nums) {
        //Method 1: HashMap and Count
        /*
        //Method 2: Sort and check -> n log n solution
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];
        int i = 1;
        while(i<n){
            //the number repeating only once will not be at idx which is multiple of 3
            if(nums[i]!=nums[i-1])
                return nums[i-1];
            if(nums[i]!=nums[i+1])
                return nums[i+1];
            i+=3;
        }
        return -1;*/
        //Method 4: Bit Manipulation
        int ones=0,twos=0;
        for (int num:
                nums) {
            ones = (ones^num) & ~(twos);
            twos = (twos^num) & ~(ones);

        }
        return ones;
    }
}
