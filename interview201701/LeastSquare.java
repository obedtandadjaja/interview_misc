import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Get the least combination of squares of a number
 * i.e. 13 = 3*3 + 2*2 instead of 2*2 + 2*2 + 2*2 + 1*1
 * i.e. 19 = 3*3 + 3*3 + 1*1 instead of 4*4 + 1*1 + 1*1 + 1*1
 */
class LeastSquare
{
  static int result = 1000;

  public static void main (String[] args) throws java.lang.Exception
  {
    result = 1000;
    least_square(13, 0);
    System.out.println(result);
    result = 1000;
    least_square(14, 0);
    System.out.println(result);
    result = 1000;
    least_square(15, 0);
    System.out.println(result);
    result = 1000;
    least_square(16, 0);
    System.out.println(result);
    result = 1000;
    least_square(17, 0);
    System.out.println(result);
    result = 1000;
    least_square(18, 0);
    System.out.println(result);
    result = 1000;
    least_square(19, 0);
    System.out.println(result);
    result = 1000;
    least_square(20, 0);
    System.out.println(result);
  }

  public static void least_square(int target, int z) {
    if(target == 0) {
      if(result > z) result = z;
    } else {
      int x = (int) Math.sqrt(target);
      if(x == 0) x = 1;
      for(int i = x; i > 0; i--) {
        int t = target-i*i;
        least_square(t, z+1);
      }
    }
  }
}