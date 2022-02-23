package a_practiceproblems.TreeProblems.BSTProblems.createBST;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckLOTIsForValidBSTTest {
    CheckLOTIsForValidBST obj = new CheckLOTIsForValidBST();
    @Test
    public void testToPass(){
        List<Integer> list = List.of(7, 4, 12, 3, 6, 8, 1, 5, 10);
        assertTrue(obj.checkLOTisValid(list));
    }

    @Test
    public void testToFail(){
        List<Integer> list = List.of(11, 6, 13, 5, 12, 10);
        assertFalse(obj.checkLOTisValid(list));
    }
}