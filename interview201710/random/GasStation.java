/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */

class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[] { 1,2 };
        int[] cost = new int[] { 2,1 };
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int lastIndex = 0;
        int total = 0;
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0) {
                total += sum;
                sum = 0;
                lastIndex = i+1;
            }
        }
        total += sum;

        return total < 0 ? -1 : lastIndex;
    }
}
