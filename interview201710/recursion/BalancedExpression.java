// Given an integer n and an array of positions ‘position[]’ (1 <= position[i] <= 2n),
// find the number of ways of proper bracket expressions that can be formed of length
// 2n such that given positions have opening bracket

// Input : n = 3, position[] = {2}
// Output : 3
// Explanation :
// The proper bracket sequences of length 6 and
// opening bracket at position 2 are:
// [ [ ] ] [ ]
// [ [ [ ] ] ]
// [ [ ] [ ] ]

// Input : n = 2, position[] = {1, 3}
// Output : 1
// Explanation: The only possibility is:
// [ ] [ ]

import java.io.*;
import java.util.*;

class BalancedExpression {


  public static void main (String[] args) {
    ArrayList<char[]> array = new ArrayList<>();
    int[] pos = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    char[] arr = new char[20];
    for(int i = 0; i < pos.length; i++) arr[pos[i]] = '[';
    arr[0] = '[';
    arr[arr.length-1] = ']';
    generate(array, arr, 1, 1);

    for(int i = 0; i < array.size(); i++) {
        for(int j = 0; j < array.get(i).length; j++) {
            System.out.print(array.get(i)[j]);
        }
        System.out.println();
    }
  }

  public static void generate(ArrayList<char[]> masterArr, char[] arr, int index, int num) {
    if(index == arr.length-1) {
      if(num == 1) masterArr.add(arr.clone());
      return;
    }

    if(arr[index] == '[') {
      generate(masterArr, arr, index+1, num+1);
      return;
    }

    arr[index] = '[';
    generate(masterArr, arr, index+1, num+1);

    if(num > 0) {
      arr[index] = ']';
      generate(masterArr, arr, index+1, num-1);
    }
  }
}
