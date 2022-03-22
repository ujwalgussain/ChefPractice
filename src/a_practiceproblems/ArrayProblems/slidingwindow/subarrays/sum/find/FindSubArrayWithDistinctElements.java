package a_practiceproblems.ArrayProblems.slidingwindow.subarrays.sum.find;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubArrayWithDistinctElements {
    /*
    https://techiedelight.com/practice/?problem=LargestDistinctSubarrays
    Print all subarrays of an array having distinct elements
    Input:  A[] = { 5, 2, 3, 5, 4, 3 }
    Output: The largest subarrays with all distinct elements are:

    { 5, 2, 3 }
    { 2, 3, 5, 4 }
    { 5, 4, 3 }
     */

    public static void main(String[] args) {
        System.out.println(findDistinctSubarrays(List.of(5, 2, 3, 5, 4, 3)));
    }
    public static Set<List<Integer>> findDistinctSubarrays(List<Integer> nums)
    {
        Set<List<Integer>> subarrays = new HashSet<>();

        // Write your code here...
        int start = 0, end=0;
        HashSet<Integer> visitedElems = new HashSet<>();
        while(end<nums.size())
        {
            while(end<nums.size() && !visitedElems.contains(nums.get(end)))
            {
                visitedElems.add(nums.get(end));
                end++;
            }
            //we got a repeating elem..but the window has distinct elems
            subarrays.add(nums.subList(start,end));//doesnt include end
            while(end<nums.size() && visitedElems.contains(nums.get(end)))
            {
                visitedElems.remove(nums.get(start++));
            }
        }
        return subarrays;
    }
}
