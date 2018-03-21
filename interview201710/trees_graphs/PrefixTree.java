/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */

class Trie {

    HashMap<Character, Trie> children;
    boolean end; // mark ending of words

    /** Initialize your data structure here. */
    public Trie() {
        this.children = new HashMap<>();
        this.end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length() >= 1) {
            if(!this.children.containsKey(word.charAt(0))) this.children.put(word.charAt(0), new Trie());
            this.children.get(word.charAt(0)).insert(word.substring(1, word.length()));
        } else {
            this.end = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 1) return this.children.containsKey(word.charAt(0)) && this.children.get(word.charAt(0)).end;
        return this.children.containsKey(word.charAt(0)) &&
               this.children.get(word.charAt(0)).search(word.substring(1, word.length()));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 1) return this.children.containsKey(prefix.charAt(0));
        return this.children.containsKey(prefix.charAt(0)) &&
               this.children.get(prefix.charAt(0)).startsWith(prefix.substring(1, prefix.length()));
    }
}


/** Alternatively - iterative solution **/
class TrieNode {
    public char val;
    public boolean end;
    public TrieNode[] children = new TrieNode[26];

    TrieNode(char c){
        this.val = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode tn = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(tn.children[c - 'a'] == null){
                tn.children[c - 'a'] = new TrieNode(c);
            }
            tn = tn.children[c - 'a']; // cursor to new node
        }
        tn.end = true;
    }

    public boolean search(String word) {
        TrieNode tn = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(tn.children[c - 'a'] == null) return false;
            tn = tn.children[c - 'a']; // cursor to new node
        }
        return tn.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode tn = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(tn.children[c - 'a'] == null) return false;
            tn = tn.children[c - 'a']; // cursor to new node
        }
        return true;
    }
}
