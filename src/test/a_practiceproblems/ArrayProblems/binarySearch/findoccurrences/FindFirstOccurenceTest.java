package a_practiceproblems.ArrayProblems.binarySearch.findoccurrences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstOccurenceTest {
    @Test
    public void test(){
        int a[] = {1,1,1,2,2,2,3,3,4,5,5};
        int expected[] =    {0,3,6,8,9};
        int find[] =        {1,2,3,4,5};
        for (int i = 0; i < find.length; i++) {
            assertEquals(expected[i],FindFirstOccurence.findFirstOccurrence(a,find[i],0,a.length-1));
        }
    }
}