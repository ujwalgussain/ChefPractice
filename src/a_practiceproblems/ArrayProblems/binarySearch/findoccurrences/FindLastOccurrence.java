package a_practiceproblems.ArrayProblems.binarySearch.findoccurrences;

public class FindLastOccurrence {
    public static int findLastOccurrence(int[] sortedArr, int target, int lo, int hi) {
        int result = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sortedArr[mid] == target &&
                    ((mid == sortedArr.length-1) || sortedArr[mid] < sortedArr[mid+1])) {
                result = mid;
                break;
            }
            if (sortedArr[mid] <= target) { ///IMPPP...!!!
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}
