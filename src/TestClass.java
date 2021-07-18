import ChefProblems.src.Test;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Stream;


public class TestClass {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            //Once Sorted we will know
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int ans = nums[i]+nums[l]+nums[r];
                if(ans==0)
                {
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;r--;
                }
                else
                {
                    if(ans>0)
                    {
                        r--;
                    }
                    else
                    {
                        l++;
                    }
                }
            }
        }
        return list;
    }
    public static String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for(String s :strs)
            len = Math.min(len,s.length());
        String prefix = "";
        out:for(int i=0;i<len;i++)
        {
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)!=c)
                    break out;
            }
            prefix+=c;
        }
        return prefix;
    }
}

