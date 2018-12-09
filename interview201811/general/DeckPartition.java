// Difficulty: Easy
// Runtime: 7 ms, faster than 90.07% of Java online submissions for X of a Kind in a Deck of Cards.

// In a deck of cards, each card has an integer written on it.
// Return true if and only if you can choose X >= 2 such that it is possible to split the
// entire deck into 1 or more groups of cards, where:
//     1. Each group has exactly X cards.
//     2. All the cards in each group have the same integer.

//  Example 1:

//  Input: [1,2,3,4,4,3,2,1]
//  Output: true
//  Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]

//  Example 2:
//  Input: [1,1,1,2,2,2,3,3]
//  Output: false
//  Explanation: No possible partition.

//  Example 3:
//  Input: [1]
//  Output: false
//  Explanation: No possible partition.

//  Example 4:
//  Input: [1,1,2,2,2,2]
//  Output: true
//  Explanation: Possible partition [1,1],[2,2],[2,2]

//  Note:
//  1 <= deck.length <= 10000
//  0 <= deck[i] < 10000

import java.util.*;

class PartitionDeck {
    public static void main(String[] args) {
        int[] deck = new int[] { 1, 1, 2, 2, 3, 3 };
        hasGroupsSizeX(deck);
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] counts = new int[10000];
        for(int i: deck) counts[i]++;

        int partition_length = 0;
        for(int count: counts) {
            if(count == 0) continue;

            if(partition_length == 0) {
                partition_length = count;
            } else {
                int gcd = gcd(count, partition_length);
                if(gcd <= 1) return false;
            }
        }

        return partition_length >= 2;
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
