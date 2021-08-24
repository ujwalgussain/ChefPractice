package a_practiceproblems.StringProblems;

import java.util.HashSet;

//LeetCode
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    /*
    * Logic:
        1. store freq of all characters
        2. for each unique character c in s
               if frequency of c already in set
                    decrement until 0 or unique frequency & add +1 to ans
               add freq to set
        3. return ans
    * */
    public int minDeletions(String s) {

        int[] freq = new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i) -'a']++;
        }
        HashSet<Integer> freqSet = new HashSet<>();
        int ans = 0;
        for(int i = 0;i<26;i++)
        {
            while(freq[i]>0)
            {
                if(!freqSet.contains(freq[i])){
                    freqSet.add(freq[i]);
                    break;
                }
                else
                {
                    freq[i]--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
