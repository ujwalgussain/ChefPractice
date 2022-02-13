package a_practiceproblems.ArrayProblems.binarySearch.bitonicarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchPeakInBitonicArrayTest {
    @Test
    public void normalBitonicArray() {
        int[] input = {1, 2, 3, 10, 7, 6};
        assertEquals(3,SearchPeakInBitonicArray.findPeakElement(input));
    }

    @Test
    public void sortedAscendingArray() {
        int[] input = {1, 2, 3, 10};
        assertEquals(3,SearchPeakInBitonicArray.findPeakElement(input));
    }

    @Test
    public void sortedDescendingArray() {
        int[] input = {10,9,8,7};
        assertEquals(0,SearchPeakInBitonicArray.findPeakElement(input));
    }
}