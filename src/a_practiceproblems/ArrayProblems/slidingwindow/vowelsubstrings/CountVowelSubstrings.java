package a_practiceproblems.ArrayProblems.slidingwindow.vowelsubstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountVowelSubstrings {

    //https://leetcode.com/problems/count-vowel-substrings-of-a-string/

    /*
    Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"
Example 2:

Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.
Example 3:

Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
     */
    public int countVowelSubstrings(String word) {
        /*
        Note : for string like
            1. aaeiou -> aaeiou, aeiou
            2. aeiouu -> aeiou, aeiouu
        Since we can have multiple occurences Hence for each substring which has all vowels we need to
            remove from start [aaeiou -> aeiou]
            from end.   [aeiouu -> aeiou]
        Better approach would be to scan substring from each idx and check for all vowels.
        With this Each iteration is similar we will be removing from start
        */
        final HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int len = word.length();
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set = new HashSet<>();
            int j = i;
            while (j < len) {
                if (!vowels.contains(word.charAt(j)))
                    break;
                set.add(word.charAt(j));
                if (set.size() == 5)
                    count++;
                j++;
            }
        }
        return count;
    }
    /*public int test(String word){
        final HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int len = word.length();
        int count = 0;
        HashMap<Character,Integer> m = new HashMap();
        int start = 0;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(!vowels.contains(c)){
                m.clear();
                start+=1;
            }
            else {
                if(i-start+1>5){
                    char startChar = word.charAt(i-5);
                    int x = m.get(startChar);
                    if(x==1)
                        m.remove(x);
                    else
                        m.put(startChar,x-1);
                }
                if(m.size()==5){
                    count+=i-
                }
            }

        }
        return count;
    }*/
}
