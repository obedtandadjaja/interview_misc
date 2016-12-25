/*
 * Hackerrank Jobs Coding Challenge
 * Hackerrank Software Engineer position
 */

public class CountingBinarySubstring {

    public static void main(String[] args) {
        System.out.println(counting("0000011110010110100110001"));
    }

    static int counting(String s) {
        int counter = 0;
        int i = 0;
        boolean isZero = false;
        int num_1 = 0;
        int num_0 = 0;
        // 00110
        for(char c : s.toCharArray()) {
            if(c == '0') {
                if(!isZero) {
                    num_0 = 1;
                } else {
                    num_0++;
                }
                if(num_1 >= num_0) {
                    counter++;
                }
                isZero = true;
            } else {
                if(isZero) {
                    num_1 = 1;
                } else {
                    num_1++;
                }
                if(num_0 >= num_1) {
                    counter++;
                }
                isZero = false;
            }
            i++;
        }
        return counter;
    }

}
