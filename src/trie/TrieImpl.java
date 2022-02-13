package trie;

public class TrieImpl {
    TrieNode root;
    void insert(String str)
    {
        if(root==null)
            root = new TrieNode();
        TrieNode temp = root;
        for(int i=0;i<str.length();i++)
        {
            System.out.printf("%s-%d\n",str.charAt(i)+"",(int)str.charAt(i)-'a');
            int idx = str.charAt(i)-'a';
            if(temp.child[idx]==null)
                temp.child[idx]=new TrieNode();
            temp = temp.child[idx];
        }
        temp.isEndOfWord=true;
    }
    boolean search(String str)
    {
        if(root==null)
            return false;
        TrieNode temp = root;
        for(int i=0;i<str.length();i++)
        {
            System.out.printf("%s-%d\n",str.charAt(i)+"",(int)str.charAt(i)-'a');
            int idx = ((int)str.charAt(i))-'a';
            if(temp.child[idx]==null)
                return false;
            temp = temp.child[idx];
        }
        return temp!=null && temp.isEndOfWord;
    }

    public static void main(String[] args) {
        TrieImpl trie= new TrieImpl();
        trie.insert("the");
        trie.insert("these");
        trie.insert("their");
        trie.insert("there");
        trie.insert("custom");
        trie.insert("thread");
        System.out.println(trie.search("thr"));
    }
}
