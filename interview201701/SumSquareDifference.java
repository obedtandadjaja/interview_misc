/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the
 * first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 */

public class SumSquareDifference {
  public static void main(String[] args) {
    int sum_square = 0;
    int square_sum = 0;
    for(int i = 1; i <= 100; i++) {
      sum_square += i*i;
      square_sum += i;
    }
    square_sum *= square_sum;
    System.out.println(square_sum - sum_square);
  }
}