public class StringRotation {
  public static void main(String[] args) {
    System.out.println("waterbottle, erbottlewat: " + isStringRotation("waterbottle", "erbottlewat"));
  }

  public static boolean isStringRotation(String str1, String str2) {
    String appendedString = str1 + str1;
    return isSubstring(appendedString, str2);
  }

  public static boolean isSubstring(String str1, String str2) {
    return str1.indexOf(str2) >= 0;
  }
}
