package Dynamic_Programming;

public class CountSubstringDifferByOneChar {
    //https://leetcode.com/problems/count-substrings-that-differ-by-one-character/submissions/

    public int countSubstrings(String s, String t) {
        //https://www.youtube.com/watch?v=EyJUpI0nowY
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int x = i;
                int y = j;
                int diff = 0;
                while(x<s.length() && j<t.length()){
                    if(s.charAt(x)!=t.charAt(y))
                        diff++;
                    if(diff==1) //substring starting from i in s and t in j are different by one character
                        c++;
                    if(diff>1)
                        break;
                    x++;
                    y++;
                }
            }
        }
        return c;
    }
    /*
Inner Loop :
i = 0 j = 0
a   b   a
i
b   a   b   a
j
start from i and j
if i!=j dif++
if diff==1
    increment cnt ie., substring from initial pos of i to current pos of i & initial pos of j to current pos of j has only one different character
if diff>1 not valid hence break

Inner Loop :
i = 0 j = 1
a   b   a
i
b   a   b   a
    j

Inner Loop :
i = 0 j = 2
a   b   a
i
b   a   b   a
        j

Inner Loop :
i = 0 j = 3
a   b   a
i
b   a   b   a
            j

     */
}
