/**
 * Largest Palindrome
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class LargestPalindrome {
  public static void main(String[] args) {
    int amount = Integer.MIN_VALUE;
    for(int i = 999; i > 0; i--) {
      for(int j = 99; j > 0; j--) {
        int product = i*j;
        if(isPalindrome(""+product)){
          if(product > amount){
            amount = product;
          }
        }
      }
    }
    System.out.println(amount);
  }

  public static boolean isPalindrome(String num) {
    if(num.length() <= 1) return true;
    if(num.charAt(0) == num.charAt(num.length()-1))
      return isPalindrome(num.substring(1, num.length()-1));
    else
      return false;
  }
}