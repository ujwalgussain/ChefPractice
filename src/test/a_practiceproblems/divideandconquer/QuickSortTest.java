package a_practiceproblems.divideandconquer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    public void test(){
        int a[] = {5,4,3,2,1};
        new QuickSort().quickSort(a,0,4);
        assertArrayEquals(new int[]{1,2,3,4,5},a);
    }
}