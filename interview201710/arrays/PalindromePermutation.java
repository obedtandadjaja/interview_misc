import java.util.*;

public class PalindromePermutation {
  public static void main(String[] args) {
    System.out.println("12341234: " + isPalindromePermutation("12341234"));
    System.out.println("taco cat: " + isPalindromePermutation("taco cat"));
    System.out.println("obed josiah: " + isPalindromePermutation("obed josiah"));
    System.out.println("tep etp: " + isPalindromePermutation("tep etp"));
    System.out.println("43214321: " + isPalindromePermutation("43214321"));
  }

  public static boolean isPalindromePermutation(String str) {
    str = str.replace(" ", "");
    HashMap<Character, Integer> map = new HashMap<>();
    int oddCounter = 0;
    for(int i = 0; i < str.length(); i++) {
      if(!map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), 1);
        oddCounter++;
      } else {
        int currentValue = map.get(str.charAt(i));
        currentValue++;
        oddCounter += currentValue % 2 == 0 ? -1 : 1;
        map.put(str.charAt(i), currentValue);
      }
    }
    return oddCounter <= 1;
  }
}
