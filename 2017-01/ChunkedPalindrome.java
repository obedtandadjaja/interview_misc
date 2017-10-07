import java.lang.Math;
public class ChunkedPalindrome {
  static int length = 0;

  public static void main(String[] args) {
    calculate("antaprezatepzapreanta", 0, "");
    System.out.println(length);
  }

  // public static void calculate(String str, int count, String s) {
  //   if(str.length() == 0) {
  //     // System.out.println(str+" "+s);
  //     // System.out.println(count*2);
  //     if(length < count*2) length = count*2;
  //   } else {
  //     int i = 0;
  //     int size = str.length()/2;
  //     String temp = "";
  //     while(i < size) {
  //       if(str.charAt(i) == str.charAt(str.length()-1)) {
  //         if(str.substring(0, i+1).equals(str.substring(str.length()-1-i, str.length()))) {
  //           calculate(str.substring(i+1, str.length()-1-i), count+1, s+"-"+str.substring(0, i+1));
  //         }
  //       }
  //       i++;
  //     }
  //     System.out.println(str+" "+s);
  //     // System.out.println(count*2+1);
  //     if(length < count*2+1) length = count*2+1;
  //   }
  // }

  public static void calculate(String str, int count, String s) {
    if(str.length() == 0) {
      length = Math.max(length, count*2+1);
    } else {
      int i = 0;
      int size = str.length()/2;
      String prefix = "";
      String postfix = "";
      while(i < size) {
        prefix += str.charAt(i);
        postfix = str.charAt(str.length()-1-i)+postfix;
        if(prefix.equals(postfix)) {
          calculate(str.substring(i+1, str.length()-1-i), count+1, s+"-"+prefix);
        }
        i++;
      }
      length = Math.max(length, count*2+1);
    }
  }
}
//(a)(nt)(a)(pre)(za)(tep)(za)(pre)(a)(nt)(a)
