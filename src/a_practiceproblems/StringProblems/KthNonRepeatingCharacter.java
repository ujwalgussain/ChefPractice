package a_practiceproblems.StringProblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthNonRepeatingCharacter {
    static Character findWithMap(String s, int k) {
        if(s.length()<k)
            throw new RuntimeException("Length is lesser than K");
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int c = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                c++;
                if (c == k)
                    return Character.valueOf(entry.getKey());
            }
        }
        throw new RuntimeException("Not Found");
    }

    public static void main(String[] args) {
        //Assuming that all chars are in same case

        //Test to pass
        System.out.println(findWithMap("ABCABE", 1)); //C
        System.out.println(findWithMap("ABCABE", 2)); //E

        //Test to fail
        //System.out.println(find("ABCABE", 3));
        //System.out.println(find("AAAAA", 1)); // all chars are same
        System.out.println(findWithMap("A",2)); // len < k
    }
}
