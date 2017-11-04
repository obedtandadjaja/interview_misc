public class BitMasking {

  public static void main(String[] args) {
    String s = "01000000100";
    System.out.println(s);
    System.out.println(bitMask(s, 2));
  }

  public static String bitMask(String s, int num) {
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for(int i = 0; i < s.length(); i++) {
      if(i < num) {
        if(s.charAt(i) == '1') {
          sb = new StringBuilder();
          for(int j = 0; j <= i; j++) {
            sb.append('1');
          }
          counter = num;
        } else {
          sb.append('0');
        }
      } else {
        if(i+num < s.length() && s.charAt(i+num) == '1') {
          counter = num*2+1;
        }
        sb.append(counter <= 0 ? '0' : '1');
        counter--;
      }
    }
    return sb.toString();
  }
}
