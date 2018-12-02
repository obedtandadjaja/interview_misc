// How do you find the missing number in a given integer array

import java.util.*;
import java.lang.Math;

class FindMissingNumber {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 2, 3, 4, 5, 7, 8, 9 }; // solution: 6, 10
    findMissingNumber(arr, 10);
    findMissingNumber1(arr, 10);
    findMissingNumber2(arr, 10);
    findMissingNumber3(arr, 10);
  }

  // using BitSet - which is just an array of booleans
  public static void findMissingNumber(int[] arr, int count) {
    System.out.println("using BitSet: ");

    int missingCount = count - arr.length;
    BitSet bitSet = new BitSet(count);

    for(int number : arr)
      bitSet.set(number - 1);

    int lastMissingIndex = 0;
    for(int i = 0; i < missingCount; i++) {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex);
    }

    System.out.println();
  }

  // using bit manipulation
  public static void findMissingNumber1(int[] arr, int count) {
    System.out.println("using bit manipulation: ");

    int cache = 0;

    for(int number : arr) {
      int power = (int) Math.pow(2, number - 1);
      cache = cache | power;
    }

    for(int i = 0; i < count; i++) {
      if((cache & 1) == 0) System.out.println(i + 1);
      cache = cache >> 1;
    }

    System.out.println();
  }

  // using regular array of booleans
  public static void findMissingNumber2(int[] arr, int count) {
    System.out.println("using array of booleans: ");

    boolean[] cache = new boolean[count];

    for(int number : arr)
      cache[number - 1] = true;

    for(int i = 0; i < cache.length; i++) {
      if(!cache[i]) System.out.println(i + 1);
    }

    System.out.println();
  }

  // half in-place and half new array - space complexity: O(missingCount)
  public static void findMissingNumber3(int[] arr, int count) {
    System.out.println("using space-optimized array of boolean: ");

    int missingCount = count - arr.length;
    boolean[] cache = new boolean[missingCount];

    for(int number : arr) {
      if((Math.abs(number) - 1) >= arr.length) {
        cache[Math.abs(number) - 1 - arr.length] = true;
      } else {
        arr[Math.abs(number) - 1] *= -1;
      }
    }

    for(int i = 0; i < arr.length; i++)
      if(arr[i] > 0) System.out.println(i + 1);

    for(int i = 0; i < cache.length; i++)
      if(!cache[i]) System.out.println(arr.length + i + 1);

    System.out.println();
  }
}
