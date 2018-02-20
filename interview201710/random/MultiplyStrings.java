// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

// Note:

// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "5023145613312";
        String num2 = "178236489132491";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int[] array = new int[num1.length() + num2.length()];
        int offset = 0, x1 = 0, x2 = 0, product = 0, index = 0;

        for(int i = num1.length()-1; i >= 0; i--) {
            index = 0;
            for(int j = num2.length()-1; j >= 0; j--) {
                x1 = num1.charAt(i) - '0';
                x2 = num2.charAt(j) - '0';
                product = x1 * x2;

                array[offset + index] += product;

                index++;
            }
            offset++;
        }

        int carry = 0, current = 0;
        for(int i = 0; i < array.length; i++) {
            current = array[i] + carry;
            carry = current / 10;
            array[i] = current % 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i >= 0; i--) {
            if(sb.length() == 0 && array[i] == 0) continue;
            sb.append(array[i]);
        }

        return sb.toString();
    }
}
