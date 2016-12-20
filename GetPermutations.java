/**
 * Get all permutations of a given string
 */

public class GetPermutations {
  public static void main(String[] args) {
    generate("","123");
  }

  public static void generate(String pre, String str) {
    if(str.length() == 0) System.out.println(pre);
    for(int i = 0; i < str.length(); i++) {
      generate(pre+str.charAt(i), str.substring(0,i)+str.substring(i+1, str.length()));
    }
  }
}