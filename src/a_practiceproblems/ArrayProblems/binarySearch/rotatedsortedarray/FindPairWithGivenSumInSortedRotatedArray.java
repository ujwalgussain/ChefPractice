package a_practiceproblems.ArrayProblems.binarySearch.rotatedsortedarray;

public class FindPairWithGivenSumInSortedRotatedArray {
    public boolean findPairs(int nums[],int n, int target){
        int maxElementIdx = SearchMaxInRotatedSortedArray.findMaxElementIdx(nums);
        int l = (maxElementIdx + 1) % n;
        int r = maxElementIdx;
        // Keep moving either l or r till they meet
        while (l != r) {
            if (nums[l] + nums[r] == target)
                return true;
            if (nums[l] + nums[r] < target)
                l = (l + 1) % n;
            else
                r = (n + r - 1) % n;
        }
        return false;
    }

}
