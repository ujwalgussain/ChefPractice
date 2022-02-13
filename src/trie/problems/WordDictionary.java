package trie.problems;

import java.util.LinkedList;

class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;
    }

    TrieNode root;

    public WordDictionary() {

    }

    public void addWord(String s) {
        if (root == null)
            root = new TrieNode();
        TrieNode temp = root;
        for (char c :
                s.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.endOfWord = true;
    }

    /*public boolean search(String s) {
        if (root == null)
            return false;
        int idx = 0;
        LinkedList<TrieNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty() && idx < s.length()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TrieNode temp = queue.poll();
                if (idx == s.length()-1 && temp.endOfWord == false)
                    continue;
                if (Character.isLetter(s.charAt(idx))) {
                    if (temp.children[s.charAt(idx) - 'a'] != null) {
                        if (idx == s.length() - 1) //TEMP IS EOW
                            return true;
                        queue.add(temp.children[s.charAt(idx) - 'a']);
                    }
                }
                else {

                    for (int i = 0; i < 26; i++) {
                        if (temp.children[i] != null) {
                            if (idx == s.length() - 1)
                                return true;
                            queue.add(temp.children[i]);
                        }
                    }
                }
            }
            idx++;
        }
        return false;
    }*/
    public boolean search(String s){
        return searchUtil(root,s.toCharArray(),0);
    }
    boolean searchUtil(TrieNode root,char[] arr, int idx){
        if(root==null)
            return false;
        if(idx==arr.length){
            if(root!=null && root.endOfWord)
                return true;
            return false;
        }
        if(Character.isLetter(arr[idx])){
            return searchUtil(root.children[arr[idx]-'a'],arr,idx+1 );
        }
        else{
            for (int i = 0; i < 26; i++) {
                if(searchUtil(root.children[i],arr,idx+1))
                    return true;
            }
        }
        return false;
    }

    void addAll(String... arr) {
        for (String s :
                arr) {
            addWord(s);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        /*wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("dad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("mad"));
        System.out.println(wordDictionary.search("dad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("..d"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search(".a."));
        //Failure Cases
        System.out.println(wordDictionary.search("e.."));
        System.out.println(wordDictionary.search("...."));*/
        wordDictionary.addAll("at", "ant", "an", "add");
       /* System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("at"));*/
        wordDictionary.addAll("bat");
        System.out.println(wordDictionary.search("b."));
    }
}
