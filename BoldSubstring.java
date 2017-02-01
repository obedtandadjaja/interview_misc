import java.util.*;
public class BoldSubstring {

  public static void main(String[] args) {
    String s = "HelloWorld HelloWorld";
    String[] substrings = {"He", "el", "llo", "oW", "Wor", "rl", "ld"};
    System.out.println(boldenSubstring(s, substrings));
  }

  public static String boldenSubstring(String s, String[] substrings) {
    boolean currentBold = false;
    StringBuilder sb = new StringBuilder();
    int currentBoldLength = 0;
    for(int i = 0; i < s.length(); i++) {
      String currentString = s.substring(i);
      boolean hasSubstring = false;
      for(int j = 0; j < substrings.length; j++) {
        if(currentString.indexOf(substrings[j]) == 0) {
          if(!currentBold) {
            currentBold = true;
            sb.append("<b>");
          }
          currentBoldLength = Math.max(currentBoldLength, substrings[j].length());
        }
      }
      sb.append(s.charAt(i));
      if(hasSubstring == false && currentBoldLength == 1) {
        if(currentBold) {
          currentBold = false;
          sb.append("</b>");
        }
      }
      if(currentBoldLength > 0) currentBoldLength--;
    }
    return sb.toString();
  }
}
