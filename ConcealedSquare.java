/**
 * Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
 * where each “_” is a single digit.
 */
import java.lang.Math;
public class ConcealedSquare {
  public static void main(String[] args) {
    long l = 0;
    for(long i = 1000000000L; i < Math.sqrt(20000000000000000000L); i++) {
      String temp = ""+(i*i);
      boolean flag = true;
      for(int j = 0; j < 10; j++) {
        if(!temp.substring(j, j+1).equals(""+(j+1))){
          flag = false;
        }
      }
    }
  }
}