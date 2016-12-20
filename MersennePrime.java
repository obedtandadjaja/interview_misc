/**
 * The first known prime found to exceed one million digits was
 * discovered in 1999, and is a Mersenne prime of the form 2^6972593−1;
 * it contains exactly 2,098,960 digits. Subsequently other Mersenne
 * primes, of the form 2p−1, have been found which contain more digits.
 * However, in 2004 there was found a massive non-Mersenne prime which
 * contains 2,357,207 digits: 28433×2^7830457+1.
 * Find the last ten digits of this prime number.
 */
import java.math.*;
public class MersennePrime {
  public static void main(String[] args) {
    BigInteger mod = new BigInteger("10000000000");
    BigInteger base = new BigInteger("2");
    BigInteger exponent = new BigInteger("7830457");
    BigInteger i = base.modPow(exponent, mod).multiply(new BigInteger("28433")).add(new BigInteger("1"));
    System.out.println(i.mod(mod));
  }
}