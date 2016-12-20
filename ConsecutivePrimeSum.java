/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime
 * below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds
 * to a prime, contains 21 terms, and is equal to 953.
 * Which prime, below one-million, can be written as the sum of the
 * most consecutive primes?
 */
import java.util.ArrayList;
public class ConsecutivePrimeSum {
  static ArrayList<Integer> array = new ArrayList<Integer>();
  public static void main(String[] args) {
    // System.out.println(isPrime(953));
    array.add(2);
    for(int i = 3; i < 4000; i+=2){
      if(isPrime(i)) array.add(i);
    }
    System.out.println(array.get(array.size()-1));
    int temp = 0;
    int index = 0;
    while(index < array.size()-1) {
      temp += array.get(index);
      if(isPrime(temp)) System.out.println(temp+" "+(index+1));
      System.out.println(temp+" "+(index+1));
      index++;
    }
  }

  public static boolean isPrime(int num) {
    for(int i = (int)Math.sqrt(num); i >= 2; i--) {
      if(num % i == 0) return false;
    }
    return true;
  }
}