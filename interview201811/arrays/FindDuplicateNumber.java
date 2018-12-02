import java.util.*;

class FindDuplicateNumber {
  public static void main(String[] args) {
    int[][] test = new int[][] {
      {1, 1, 2, 2, 3, 4, 5},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 2, 3, 4, 5, 6, 7},
      {1, 2, 1, 1, 1, 1, 1},
    };

    for (int[] input : test) {
      System.out.println("Array with Duplicates\t\t: " + Arrays.toString(input));
      System.out.println("After removing duplicates\t: " + Arrays.toString(removeDuplicates(input)));
      System.out.println("After removing duplicates 2\t: " + Arrays.toString(removeDuplicates(input)));
    }
  }

  // sort and do logic in-place
  public static int[] removeDuplicates(int[] arr) {
    Arrays.sort(arr);

    int[] result = new int[arr.length];
    int previous = arr[0];
    result[0] = previous;

    for(int i = 1; i < arr.length; i++) {
      if(arr[i] == previous) {
        result[i] = 0;
      } else {
        previous = arr[i];
        result[i] = previous;
      }
    }

    return result;
  }

  // avoid sorting
  public static int[] removeDuplicates2(int[] arr) {
    int[] cache = new int[arr.length];
    int[] result = new int[arr.length];

    for(int number : arr)
      cache[number - 1] += 1;

    int currentIndex = 0;
    for(int i = 0; i < cache.length; i++) {
      if(cache[i] > 0) {
        result[currentIndex] = i + 1;
        currentIndex += cache[i];
      }
    }

    return result;
  }
}
