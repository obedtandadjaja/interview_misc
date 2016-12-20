/**
 * 2520 is the smallest number that can be divided by each of the
 * numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible
 * by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {
  public static void main(String[] args) {
    int temp = 1;
    while(true) {
      temp++;
      if(check(temp)) break;
    }
    System.out.println(temp);
  }

  public static boolean check(int temp) {
    for(int i = 1; i <= 20; i++)
      if(temp % i != 0) {
        return false;
      }
    return true;
  }
}