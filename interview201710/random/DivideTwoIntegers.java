class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -3;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if(divisor == 0 || divisor == 1) return dividend;
        if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        if(ldividend < ldivisor) return 0;
        
        int totalMultiple = 1;
        
        int multiple = 1;
        long currDivisor = ldivisor;
        ldividend -= ldivisor;
                
        while(currDivisor + currDivisor <= ldividend) {
            currDivisor += currDivisor;
            multiple += multiple;
            ldividend -= currDivisor;
            
            totalMultiple += multiple;
        }
        
        while(ldividend >= ldivisor) {
            while(currDivisor > ldividend) {
                currDivisor = currDivisor >> 1;
                multiple = multiple >> 1;
            }
            ldividend -= currDivisor;
            
            totalMultiple += multiple;
        }
        
        return totalMultiple * sign;
    }
}
