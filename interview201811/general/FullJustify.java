/*
  Difficulty: Medium

  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
  You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

  Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
  Extra spaces between words should be distributed as evenly as possible.
  If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
  For the last line of text, it should be left justified and no extra space is inserted between words.

  Your program should return a list of strings, where each string represents a single line.

  Example:

  words: ["This", "is", "an", "example", "of", "text", "justification."]

  L: 16.

  Return the formatted lines as:

  [
  "This    is    an",
  "example  of text",
  "justification.  "
  ]
  Note: Each word is guaranteed not to exceed L in length. 
 */

public class Solution {
  public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
    ArrayList<String> result = new ArrayList();

    if(A.size() == 0) {
      return result;
    }

    ArrayList<ArrayList<String>> wordsPerLine = wordsPerLine(A, B);
    StringBuilder curr = new StringBuilder();

    for(int i = 0; i < wordsPerLine.size() - 1; i++) {
      ArrayList<String> words = wordsPerLine.get(i);

      int totalChars = 0;
      for(String s : words) totalChars += s.length();

      int spaces = B - totalChars;
      int spacesPerWord = words.size() == 1 ? B - totalChars : spaces / (words.size() - 1);
      int extraSpaces = words.size() == 1 ? B - totalChars : spaces % (words.size() - 1);

      for(int j = 0; j < words.size() - 1; j++) {
        String s = words.get(j);
        curr.append(s);

        for(int k = 0; k < spacesPerWord; k++) curr.append(' ');

        if(extraSpaces > 0) {
          curr.append(' ');
          extraSpaces--;
        }
      }
      curr.append(words.get(words.size() - 1));
      for(int j = 0; j < extraSpaces; j++) curr.append(' ');

      result.add(curr.toString());
      curr = new StringBuilder();
    }

    curr.append(wordsPerLine.get(wordsPerLine.size() - 1).get(0));
    for(int i = 1; i < wordsPerLine.get(wordsPerLine.size() - 1).size(); i++) {
      curr.append(' ');
      curr.append(wordsPerLine.get(wordsPerLine.size() - 1).get(i));
    }

    int pad = B - curr.length();
    for(int i = 0; i < pad; i++) curr.append(' ');

    result.add(curr.toString());

    return result;
  }

  public ArrayList<ArrayList<String>> wordsPerLine(ArrayList<String> A, int B) {
    ArrayList<ArrayList<String>> result = new ArrayList();

    ArrayList<String> curr = new ArrayList();
    int totalChars = 0;
    for(int i = 0; i < A.size(); i++) {
      if(totalChars + A.get(i).length() <= B) {
        totalChars += A.get(i).length();
        totalChars++;
        curr.add(A.get(i));
      } else {
        result.add(curr);

        totalChars = A.get(i).length();
        totalChars++;
        curr = new ArrayList();
        curr.add(A.get(i));
      }
    }

    result.add(curr);

    return result;
  }
}
