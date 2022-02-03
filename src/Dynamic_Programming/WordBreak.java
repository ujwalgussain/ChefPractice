package Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //https://www.youtube.com/watch?v=2NaaM_z_Jig  PEPCODING
        HashSet<String> set = new HashSet<>(wordDict);
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String word2check = s.substring(j, i + 1);
                System.out.println(word2check);
                if (set.contains(word2check)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }
        return dp[s.length() - 1] > 0;
    }

    public static void main(String[] args) {
        new WordBreak().wordBreak("leetcode", List.of("leet","code"));
    }
}
/*
dp[] array
l   e   e   t   c   o   d   e
0   0   0   0   0   0   0   0
String will be processed in following order:

l
le
e
lee
ee
e
leet ----> j=0 and i=3...hence dp[3]=dp[3]+1 = 1;
    dp[] array
    l   e   e   t   c   o   d   e
    0   0   0   1   0   0   0   0
eet
et
t
leetc
eetc
etc
tc
c
leetco
eetco
etco
tco
co
o
leetcod
eetcod
etcod
tcod
cod
od
d
leetcode
eetcode
etcode
tcode
code ---------> j = 7 and i= 4  dp[7] = dp[3]+1
    dp[] array
    l   e   e   t   c   o   d   e
    0   0   0   1   0   0   0   2 ---> we can make 2 sentences
ode
de
e
*/
