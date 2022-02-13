package a_practiceproblems.ArrayProblems.binarySearch.findoccurrences;

import java.util.List;

public class FindFirstAndLastOccurrence {
    public static List<Integer> find(int sortedArr[], int target){
        int firstIdx = FindFirstOccurence.findFirstOccurrence(sortedArr,target,0,sortedArr.length-1);
        int lastIdx = FindLastOccurrence.findLastOccurrence(sortedArr,target,firstIdx,sortedArr.length-1);
        return List.of(firstIdx,lastIdx);
    }
}
