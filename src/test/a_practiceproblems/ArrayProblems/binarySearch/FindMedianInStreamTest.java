package a_practiceproblems.ArrayProblems.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianInStreamTest {
    FindMedianInStream obj = new FindMedianInStream();
    @Test
    public void test(){
        int a[] = new int[]{3,2,1,5,6,7};
        double medians[] = {3,2.5,2,2.5,3,4};
        for (int i = 0; i < a.length; i++)  {
            obj.addNum(a[i]);
            assertEquals(medians[i], obj.findMedian());
        }
    }

}