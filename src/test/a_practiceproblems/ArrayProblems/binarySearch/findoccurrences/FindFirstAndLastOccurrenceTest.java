package a_practiceproblems.ArrayProblems.binarySearch.findoccurrences;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstAndLastOccurrenceTest {
    @Test
    public void test(){
        int a[] = {1,1,1,2,2,2,3,3,4,5,5};
        int find[] =        {1,2,3,4,5};
        List<List<Integer>> lists = List.of(
                List.of(0,2),
                List.of(3,5),
                List.of(6,7),
                List.of(8,8),
                List.of(9,10)
        );
        for (int i = 0; i < find.length; i++) {
            assertEquals(lists.get(i),FindFirstAndLastOccurrence.find(a,find[i]));
        }
    }

}