/*
Implement pow(x, n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100
 */

import java.lang.Math;

class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.12211, 13241));
    }

    public static double myPow(double x, int n) {
        double result = 1;

        long power = Math.abs((long) n);
        while(power > 0) {
            if((power & 1) == 1) result *= x;
            power >>= 1;
            x *= x;
        }

        return n < 0 ? 1/result : result;
    }
}
