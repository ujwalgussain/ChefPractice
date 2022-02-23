package Dynamic_Programming.lis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingThenDecreasingSubsequenceTest {
    LongestIncreasingThenDecreasingSubsequence obj = new LongestIncreasingThenDecreasingSubsequence();
    @Test
    public void test(){
        /*
                8, 6, 3, 4, 2, 1
        lis1 ->[1, 1, 1, 2, 1, 1]
        lis2 ->[5, 4, 3, 3, 2, 1]

         */
        List<Integer> list = new ArrayList<>(List.of(8, 6, 3, 4, 2, 1));
        assertEquals(5,obj.longestSubsequenceLength(list));
    }
}