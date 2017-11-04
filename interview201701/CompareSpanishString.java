public class CompareSpanishString {
  public static void main(String[] args) {
    String s1 = "aschdfschasch";
    String s2 = "aschdfschasch";
    System.out.println(check(s1,s2));
  }

  public static boolean check(String a, String b) {
    if(a.length() != b.length()) return false;
    for(int i = 0; i < a.length(); i++) {
      if(a.charAt(i) != b.charAt(i)) return false;
      else if(a.charAt(i) == 'c' && i < a.length()-1 && a.charAt(i+1) == 'h')
        if(b.charAt(i) != 'c' || i >= a.length()-1 || b.charAt(i+1) != 'h')
          return false;
        else
          i++;
    }
    return true;
  }
}