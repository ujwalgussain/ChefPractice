package Dynamic_Programming;

import a_practiceproblems.TestClass3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class WordBreak2 {


    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        List<List<String>> lists = new ArrayList<>();
        IntStream.rangeClosed(1,len).forEach(x->lists.add(new ArrayList<>()));
        for (int end = 0; end < len; end++) {
            for (int start = 0; start <= end; start++) {
                String word2Check = s.substring(start, end +1);
                System.out.println(word2Check);
                if(set.contains(word2Check)){
                    System.out.printf("\t\tBefore lists[%s] -> %s\n",end, lists.get(end));
                    if(start>0){
                        System.out.printf("\t\tChecking lists[%s] -> %s\n",start-1, lists.get(start-1));
                        for(String sentence : lists.get(start-1)){
                            lists.get(end).add(sentence+" "+word2Check);
                        }
                    }else {
                        String sentence = word2Check;
                        lists.get(end).add(sentence);
                    }
                    System.out.printf("\t\tUpdate lists[%s] -> %s\n",end, lists.get(end));
                }
            }
        }
        System.out.println("After iteration final state : "  + lists);
        //lists.stream().filter(x->x!=null && !x.isEmpty()).forEach(System.out::println);
        return lists.get(len-1);
    }
    public static void main(String[] args) {
        System.out.println(new WordBreak2().wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
    /*
Ex:
s = "catsanddog"  dict: ["cat","cats","and","sand","dog"]

c
ca
a
cat
	Before -> []
	After update -> [cat]
at
t
cats
	Before -> []
	After update -> [cats]
ats
ts
s
catsa
atsa
tsa
sa
a
catsan
atsan
tsan
san
an
n
catsand
atsand
tsand
sand
	Before -> []
	After update -> [cat sand]
and
	Before -> [cat sand]
	After update -> [cat sand, cats and]
nd
d
catsandd
atsandd
tsandd
sandd
andd
ndd
dd
d
catsanddo
atsanddo
tsanddo
sanddo
anddo
nddo
ddo
do
o
catsanddog
atsanddog
tsanddog
sanddog
anddog
nddog
ddog
dog
	Before -> []
	After update -> [cat sand dog, cats and dog]
og
g


After iteration final state : [[], [], [cat], [cats], [], [], [cat sand, cats and], [], [], [cat sand dog, cats and dog]]

Answer:

[cat sand dog, cats and dog]
  */
}
