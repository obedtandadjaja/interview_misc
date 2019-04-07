/*
  Difficulty: Medium

  Given an array of strings, group anagrams together.

  Example:

  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  Output:
  [
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
  ]
  Note:

  All inputs will be in lowercase.
  The order of your output does not matter.
 */

class Solution {
  // 1 : categorize by sorted string
  // O(NK log K) where N is number of strings and K is max length of a string
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> dict = new HashMap<>();

    for(String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sorted = String.valueOf(charArray);

      if(!dict.containsKey(sorted)) dict.put(sorted, new ArrayList<>());
      dict.get(sorted).add(str);
    }

    List<List<String>> result = new ArrayList<>();
    for(List<String> list : dict.values()) {
      result.add(list);
    }

    return result;
  }

  // 2 : categorize by char count
  // O(NK) where N is number of strings and K is max length of a string
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> dict = new HashMap<>();

    int[] charCount = new int[26];
    for(String str : strs) {
      Arrays.fill(charCount, 0);

      for(char c : str.toCharArray())
        charCount[c - 'a']++;

      StringBuilder sb = new StringBuilder();
      for(int count : charCount)
        sb.append(count + " ");

      if(!dict.containsKey(sb.toString())) dict.put(sb.toString(), new ArrayList<>());
      dict.get(sb.toString()).add(str);
    }

    return new ArrayList(dict.values());
  }
}
