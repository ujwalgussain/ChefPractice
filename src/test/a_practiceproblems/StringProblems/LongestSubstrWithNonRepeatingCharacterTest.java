package a_practiceproblems.StringProblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstrWithNonRepeatingCharacterTest {
    LongestSubstrWithNonRepeatingCharacter obj = new LongestSubstrWithNonRepeatingCharacter();

    @Test
    public void test1(){
        String s = "abcabcbb";
        assertEquals(3,obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test2(){
        String s = "abba";
        assertEquals(2,obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test3(){
        String s = "tmmuzxt";
        assertEquals(5,obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test4(){
        String s = "bbbbbb";
        assertEquals(1,obj.lengthOfLongestSubstring(s));
    }

}