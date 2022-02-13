package a_practiceproblems.ArrayProblems.binarySearch.bitonicarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInBitonicArrayTest {
    @Test
    public void searchMiddleElement() {
        int[] input = {1, 2, 3, 10, 7, 6};
        assertElement(input);
    }

    @Test
    public void searchInSortedAscendingArray() {
        int[] input = {1, 2, 3, 10};
        assertElement(input);
    }

    @Test
    public void searchInSortedDescendingArray() {
        int[] input = {10,9,8,7};
        assertElement(input);
    }
    private void assertElement(int input[]){
        for (int i=0;i<input.length; i++) {
            int actual = SearchInBitonicArray.search(input, input[i]);
            assertEquals(i, actual);
        }
    }
}