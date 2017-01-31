import java.util.*;
public class FastExponentiation {

  public static void main(String[] args) {
    System.out.println(fastExp(11, 5));
  }

  /*
    Complexity: O((n log num)^power)
    Explanation:
    (1) 2^6 = 4^3 = (2^2)^3 = 2^(2*3)
    (2) 4^3 = 4*16^1 = 64
   */
  public static int fastExp(int num, int power) {
    if(num == 0) return 0;
    else if(power == 0) return 1;
    else if(num == 1) return 1;
    else if(power == 1) return num;
    else if(power % 2 == 0) return fastExp(num*num, power/2);
    else return num*fastExp(num*num, (power-1)/2);
  }
}
