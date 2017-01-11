
import java.util.ArrayList;

public class GenerateParens {

  public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
    if (leftRem < 0 || rightRem < leftRem) return; // invalid state

    if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '('; // Add left and recurse
      addParen(list, leftRem - 1, rightRem, str, index + 1);

      str[index] = ')'; // Add right and recurse
      addParen(list, leftRem, rightRem - 1, str, index + 1);
    }
  }

  public static ArrayList<String> generateParens(int count) {
    char[] str = new char[count*2];
    ArrayList<String> list = new ArrayList<String>();
    addParen(list, count, count, str, 0);
    return list;
  }

  public static ArrayList<String> generateParens2(int left, int right, String s) {
    ArrayList<String> result = new ArrayList<>();
    if(right == 0 && left == 0) {
      result.add(s);
      return result;
    } else {
      if(left > 0) {
        result.addAll(generateParens2(left-1, right, s+"("));
      }
      if(left < right) {
        result.addAll(generateParens2(left, right-1, s+")"));
      }
      return result;
    }
  }

  public static void main(String[] args) {
    ArrayList<String> list = generateParens(6);
    for (String s : list) {
      System.out.println(s);
    }
    System.out.println(list.size());
    ArrayList<String> list2 = generateParens2(6, 6, "");
    for (String s : list2) {
      System.out.println(s);
    }
    System.out.println(list2.size());
  }

}
