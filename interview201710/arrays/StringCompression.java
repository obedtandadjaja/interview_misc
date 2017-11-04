import java.util.*;

public class StringCompression {
  public static void main(String[] args) {
    System.out.println("aaabbccddeeff: " + compressString("aaabbccddeeff"));
  }

  public static String compressString(String str) {
    if(str.length() == 0) return str;

    int counter = 0;
    StringBuilder compressed = new StringBuilder();

    for(int i = 0; i < str.length(); i++) {
      counter++;

      if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressed.append(str.charAt(i));
        compressed.append(counter);
        counter = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }
}
