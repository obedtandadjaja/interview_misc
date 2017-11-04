/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the
 * terms increases by 3330, is unusual in two ways: (i) each of the
 * three terms are prime, and, (ii) each of the 4-digit numbers are
 * permutations of one another.
 * There are no arithmetic sequences made up of three 1-, 2-, or
 * 3-digit primes, exhibiting this property, but there is one other
 * 4-digit increasing sequence.
 * What 12-digit number do you form by concatenating the three terms
 * in this sequence?
 */
import java.lang.Math;
public class PrimePermutations {
  public static void main(String[] args) {
    String[] array = find();
    for(int i = 0; i < 3; i++) {
      System.out.println(array[i]);
    }
    // String[] array = {"1487", "4817", "8147"};
    // System.out.println(isPrime(array));
  }

  public static String[] find() {
    String[] array = new String[3];
    for(int i = 1000; i < 9999; i++) {
      if(i == 1487) continue;
      for(int j = 1; j < 3333; j++) {
        array[0] = ""+i;
        array[1] = ""+(i+j);
        array[2] = ""+(i+j+j);
        if(isPrime(array)) if(isPermutation(array)) return array;
      }
    }
    return null;
  }

  public static boolean isPermutation(String[] array) {
    for(int i = 0; i < 4; i++) {
      if(!array[1].contains(""+array[0].charAt(i)) ||
        !array[2].contains(""+array[0].charAt(i)))
        return false;
    }
    for(int i = 0; i < 4; i++) {
      if(!array[0].contains(""+array[1].charAt(i)) ||
        !array[2].contains(""+array[1].charAt(i)))
        return false;
    }
    for(int i = 0; i < 4; i++) {
      if(!array[1].contains(""+array[2].charAt(i)) ||
        !array[0].contains(""+array[2].charAt(i)))
        return false;
    }
    return true;
  }

  public static boolean isPrime(String[] array) {
    for(int i = 0; i < 3; i++) {
      int num = Integer.parseInt(array[i]);
      for(int j = (int)Math.sqrt(num); j > 1; j--) {
        if(num % j == 0) return false;
      }
    }
    return true;
  }
}