/**
 * Consider the fraction, n/d, where n and d are positive integers.
 * If n less than d and HCF(n,d)=1, it is called a reduced proper
 * fraction.
 * If we list the set of reduced proper fractions for d ≤ 8 in
 * ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7,
 * 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * It can be seen that 2/5 is the fraction immediately to the
 * left of 3/7.
 * By listing the set of reduced proper fractions for
 * d ≤ 1,000,000 in ascending order of size, find the numerator
 * of the fraction immediately to the left of 3/7.
 */
import java.util.ArrayList;
public class OrderedFractions {
  public static void main(String[] args) {
    ArrayList<String> array = new ArrayList<String>();
    int i = 0; int j = 0;
    for(i = 1; i < 1000000; i++) {
      for(j = 1000000-i; j >= i; j--) {
        if((double)i/(double)j > 3.0/7.0) break;
        if(GCD(i, j) == 1) {
          System.out.println(i+" "+j);
          array.add(i+"/"+j);
        }
      }
    }
    for(i = 0; i < array.size(); i++)
      if(array.get(i).equals("3/7")) System.out.println(array.get(i-1));
  }
  public static int GCD(int num1, int num2) {
    if(num2 == 0) {
      return num1;
    }
    return GCD(num2, num1%num2);
  }
}