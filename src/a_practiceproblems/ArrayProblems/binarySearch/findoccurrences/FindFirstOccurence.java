package a_practiceproblems.ArrayProblems.binarySearch.findoccurrences;

public class FindFirstOccurence {
    public static int findFirstOccurrence(int[] sortedArr, int target, int lo, int hi) {
        int result = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sortedArr[mid] == target &&
                    ((mid == 0) || sortedArr[mid - 1] < sortedArr[mid])) {
                result = mid;
                break;
            }
            if (sortedArr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}
