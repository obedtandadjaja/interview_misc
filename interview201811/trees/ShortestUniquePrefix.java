/*
  Difficulty: Medium

  Find shortest unique prefix to represent each word in the list.

  Example:

  Input: [zebra, dog, duck, dove]
  Output: {z, dog, du, dov}
  where we can see that
  zebra = z
  dog = dog
  duck = du
  dove = dov
*/

public class Solution {
  public ArrayList<String> prefix(ArrayList<String> A) {
    Trie root = new Trie();

    // create trie
    for(String a : A) {
      Trie curr = root;
      for(char c : a.toCharArray()) {
        if(curr.children[c - 'a'] == null)
          curr.children[c - 'a'] = new Trie();

        curr = curr.children[c - 'a'];
        curr.count++; // update children's count
      }
    }

    ArrayList<String> result = new ArrayList();

    for(String a : A) {
      Trie curr = root;
      boolean found = false;
      for(int i = 0; i < a.length(); i++) {
        // when curr count is 1 then we know it's unique
        if(curr.children[a.charAt(i) - 'a'].count == 1) {
          found = true;
          result.add(a.substring(0, i + 1));
          break;
        }

        curr = curr.children[a.charAt(i) - 'a'];
      }

      // if unique not found then we add the whole string
      if(!found) result.add(a);
    }

    return result;
  }

  // have a trie class with count, when count > 1 then we know that it is not unique
  class Trie {
    Trie[] children;
    int count;

    public Trie() {
      this.count = 0;
      this.children = new Trie[26];
    }
  }
}
