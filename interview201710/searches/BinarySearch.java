import java.util.*;
import java.lang.Math;

public class BinarySearch {

  public static enum BinarySearchType {
    BINARY_SEARCH_EXACT,
    BINARY_SEARCH_CLOSEST
  }

  private static Random random = new Random();

  public static void main(String[] args) {
    startBinarySearchTests(BinarySearchType.BINARY_SEARCH_EXACT);
    startBinarySearchTests(BinarySearchType.BINARY_SEARCH_CLOSEST);
  }

  public static void startBinarySearchTests(BinarySearchType type) {
    System.out.println("---------------------------");
    System.out.println(type == BinarySearchType.BINARY_SEARCH_EXACT ? "Binary search exact" : "Binary search closest");
    System.out.println("---------------------------");
    for(int i = 0; i < 20; i++) {
      int[] randomArray = generateRandomArray();
      int randomSearch = type == BinarySearchType.BINARY_SEARCH_EXACT ? randomArray[random.nextInt(randomArray.length)] : random.nextInt(50);
      System.out.println("Searching number \t" + randomSearch);
      System.out.print("Array to search: \t");
      printArray(randomArray);
      int index = binarySearch(type, randomArray, randomSearch);
      System.out.println("index: \t\t\t" + index + (index == -1 ? "" : (" array[" + index + "] = " + randomArray[index])));
    }
    System.out.println("\n");
  }

  public static int[] generateRandomArray() {
    int arraySize = random.nextInt(20) + 1; // 1 - 20
    int[] array = new int[arraySize];
    for(int i = 0; i < arraySize; i++) {
      array[i] = random.nextInt(50);
    }
    Arrays.sort(array);
    return array;
  }

  public static void printArray(int[] array) {
    System.out.print("{");
    for(int i = 0; i < array.length; i++) System.out.print(array[i] + ", ");
    System.out.print("}\n");
  }

  // returns index of element
  public static int binarySearch(BinarySearchType type, int[] array, int i) {
    switch(type) {
      case BINARY_SEARCH_EXACT:
        return binarySearchExact(array, i, 0, array.length-1);
      case BINARY_SEARCH_CLOSEST:
        return binarySearchClosest(array, i, 0, array.length-1);
      default:
        return -1;
    }
  }

  public static int binarySearchExact(int[] array, int i, int start, int end) {
    if(start <= end) {
      int middle = (start+end)/2;
      if(array[middle] == i) {
        return middle;
      } else if(i < array[middle]) {
        return binarySearchExact(array, i, start, middle-1);
      } else {
        return binarySearchExact(array, i, middle+1, end);
      }
    } else {
      return -1;
    }
  }

  public static int binarySearchClosest(int[] array, int i, int start, int end) {
    if(start <= end) {
      int middle = (start+end)/2;
      if(array[middle] == i) {
        return middle;
      } else if(i < array[middle]) {
        return binarySearchClosest(array, i, start, middle-1);
      } else {
        return binarySearchClosest(array, i, middle+1, end);
      }
    } else {
      // there is three possible closest values
      // index-1, index, index+1
      // do comparison for each

      int lowest = Integer.MAX_VALUE;
      int index = -1;

      // index
      if(lowest > Math.abs(i - array[start])) {
        lowest = Math.abs(i - array[start]);
        index = start;
      }

      // index-1
      if((start-1) >= 0 && lowest > Math.abs(i - array[start-1])) {
        lowest = Math.abs(i - array[start-1]);
        index = start-1;
      }

      // index+1
      if((start+1) < array.length && lowest > Math.abs(i - array[start+1])) {
        lowest = Math.abs(i - array[start+1]);
        index = start+1;
      }
      return index;
    }
  }
}
