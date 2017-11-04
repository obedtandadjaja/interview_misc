import java.util.*;

public class MergeSort {
  static enum MergeSortType {
    MERGE_SORT_EXTRA_SPACE,
    MERGE_SORT_NO_EXTRA_SPACE
  }

  static Random random = new Random();

  public static void main(String[] args) {
    startMergeSortTests(MergeSortType.MERGE_SORT_EXTRA_SPACE);
    startMergeSortTests(MergeSortType.MERGE_SORT_NO_EXTRA_SPACE);
  }

  public static void startMergeSortTests(MergeSortType type) {
    System.out.println("---------------------------");
    System.out.println(type == MergeSortType.MERGE_SORT_EXTRA_SPACE ? "Merge sort with extra space" : "In-line merge sort");
    System.out.println("---------------------------");
    for(int i = 0; i < 20; i++) {
      int[] randomArray = generateRandomArray();
      System.out.print("unsorted: \t");
      printArray(randomArray);
      int[] sortedArray = type == MergeSortType.MERGE_SORT_EXTRA_SPACE ? mergeSort1(randomArray) : mergeSort2(randomArray);
      System.out.print("sorted: \t");
      printArray(sortedArray);
    }
    System.out.println("\n");
  }

  public static int[] generateRandomArray() {
    int arraySize = random.nextInt(20) + 1; // 1 - 20
    int[] array = new int[arraySize];
    for(int i = 0; i < arraySize; i++) {
      array[i] = random.nextInt(500);
    }
    return array;
  }

  public static void printArray(int[] array) {
    System.out.print("{");
    for(int i = 0; i < array.length; i++) System.out.print(array[i] + ", ");
    System.out.print("}\n");
  }

  // MERGE SORT LOGIC:
  // {5,4,3,2,1}
  // {5,4,3},{2,1}
  // {5,4},{3},{2},{1}
  // {5},{4},{3},{2},{1}
  // {4,5},{3},{2},{1}
  // {3,4,5},{1,2}
  // {1,2,3,4,5}

  // 1. DIVIDE ARRAY TO TWO
  // 2. MERGE BACK AND DO SORT

  // merge sort with extra space
  public static int[] mergeSort1(int[] array) {
    if(array.length <= 1) {
      return array;
    } else {
      int middle = array.length/2;

      // recursive step
      int[] leftArray = mergeSort1(Arrays.copyOfRange(array, 0, middle));
      int[] rightArray = mergeSort1(Arrays.copyOfRange(array, middle, array.length));
      int[] mergedArray = new int[array.length];

      // data pointers
      int leftPointer = 0;
      int rightPointer = 0;

      // sort the data
      for(int mergedPointer = 0; mergedPointer < mergedArray.length; mergedPointer++) {
        if(leftPointer == leftArray.length) {
          mergedArray[mergedPointer] = rightArray[rightPointer];
          rightPointer++;
        } else if(rightPointer == rightArray.length) {
          mergedArray[mergedPointer] = leftArray[leftPointer];
          leftPointer++;
        } else if(leftArray[leftPointer] < rightArray[rightPointer]) {
          mergedArray[mergedPointer] = leftArray[leftPointer];
          leftPointer++;
        } else {
          mergedArray[mergedPointer] = rightArray[rightPointer];
          rightPointer++;
        }
      }

      return mergedArray;
    }
  }

  // merge sort with no extra space (in-line mergesort)
  // advantage: save space
  // disadvantage: more computing power - right rotations
  public static int[] mergeSort2(int[] array) {
    inLineMergeSort(array, 0, array.length-1);
    return array;
  }

  public static void inLineMergeSort(int[] array, int start, int end) {
    if(start < end) {
      int middle = (start+end)/2;

      // recursive step
      inLineMergeSort(array, start, middle);
      inLineMergeSort(array, middle+1, end);

      int leftPointer = start; int offset = 0;
      int rightPointer = middle+1;

      for(int i = 0; i < end-start; i++) {
        if(leftPointer == middle+1 || rightPointer == end+1) {
          // if either one of the pointer reaches its end then it should be sorted already
          break;
        } else if(array[offset+leftPointer] < array[rightPointer]) {
          // when left pointer is already in its place then do nothing
          leftPointer++;
        } else if(array[offset+leftPointer] >= array[rightPointer]) {
          // when right pointer is less
          // put the pointer to temporary variable
          int temp = array[rightPointer];

          // rotate the left array by 1 to the right
          rightRotation(array, offset+leftPointer, rightPointer);
          offset++;

          // assign the lowest value
          array[start+i] = temp;
          rightPointer++;
        }
      }
    }
  }

  public static void rightRotation(int[] array, int start, int end) {
    for(int i = end-1; i >= start; i--) array[(i+1) % array.length] = array[i];
  }
}
