package a_practiceproblems.ArrayProblems.slidingwindow;

public class FindAllAnagramsOfStr2InStr1 {

    /*
    * Ex:
    *   s1 = abcdefcba  s2=abc
    *   suppose window has bcd
    *           diff = 2 and
    *           adding d after removing a wouldn't make any difference as
    *               alphabets-> a=1 b=0 c=0 d=-1 and diff wont be update
    *
    *   similarly
    *           cba when we remove f
    *           before removing f -> a=1 b=0 c=0 d=0 f=-1
    *           after removing f ->  a=1 b=0 c=0 d=0 f=0
    * */


    public static int find(String s1, String s2)
    {
        int alphabets[] = new int[26];
        for(char c: s2.toCharArray())
            alphabets[c-'a']++;
        int len = s2.length();
        int start=0,diff = len,soln=0;
        for(int end=0;end<s1.length();end++)
        {
            if(end-start>=len)
            {
                //now the window size is greater than len of str2
                //so we will need to remove chars from start
                char temp = s1.charAt(start++);
                //now we would need to increment the count of temp as it is no longer the part of current window
                alphabets[temp-'a']++;
                //after removing if the count is 0 or less then it was not the part of s2. hence dont update diff
                if(alphabets[temp-'a']>0)
                    diff++;
            }
            char temp = s1.charAt(end);
            alphabets[temp-'a']--;
            //after
            if(alphabets[temp-'a']>=0)
                diff--;
            if(diff==0) {
                System.out.println("start" + start);
                soln++;
            }
        }
        return soln;
    }

    public static void main(String[] args) {
        System.out.println(find("barfoofoobarthefoobarman","barfoothe"));
    }
}
