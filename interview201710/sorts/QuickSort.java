import java.util.*;

public class QuickSort {
  static Random random = new Random();

  public static void main(String[] args) {
    startQuickSortTests();
  }

  public static void startQuickSortTests() {
    System.out.println("---------------------------");
    System.out.println("Quick sort");
    System.out.println("---------------------------");
    for(int i = 0; i < 20; i++) {
      ArrayList<Integer> randomArray = generateRandomArray();
      System.out.print("unsorted: \t");
      printArray(randomArray);
      ArrayList<Integer> sortedArray = quickSort(randomArray);;
      System.out.print("sorted: \t");
      printArray(sortedArray);
    }
    System.out.println("\n");
  }

  public static ArrayList<Integer> generateRandomArray() {
    int arraySize = random.nextInt(20) + 1; // 1 - 20
    ArrayList<Integer> array = new ArrayList<>(arraySize);
    for(int i = 0; i < arraySize; i++) {
      array.add(random.nextInt(500));
    }
    return array;
  }

  public static void printArray(ArrayList<Integer> array) {
    System.out.print("{");
    for(int i = 0; i < array.size(); i++) System.out.print(array.get(i) + ", ");
    System.out.print("}\n");
  }

  // QUICK SORT LOGIC:
  // {5,4,3,2,1}
  // {1,2},{3},{4,5}
  // {1},{2},{3},{4},{5}
  // {1,2},{3},{4,5}
  // {1,2,3,4,5}

  // 1. PICK A MIDDLE VALUE
  // 2. DIVIDE THE ARRAY TO TWO:
  //    - THOSE THAT ARE SMALLER THAN MIDDLE VALUE
  //    - THOSE THAT ARE BIGGER THAN MIDDLE VALUE
  // THIS IS WHY QUICKSORT'S PERFORMANCE HEAVILY RELIES ON HOW ACCURATE OUR MIDDLE VALUE IS

  public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
    if(array.size() <= 1) {
      return array;
    } else {
      int middle = array.get(array.size()/2);
      ArrayList<Integer> smaller = new ArrayList<>();
      ArrayList<Integer> bigger = new ArrayList<>();
      ArrayList<Integer> merged = new ArrayList<>();

      for(int i = 0; i < array.size(); i++) {
        if(i != array.size()/2) {
          int current = array.get(i);
          if(array.get(i) < middle) {
            smaller.add(current);
          } else {
            bigger.add(current);
          }
        }
      }

      merged.addAll(quickSort(smaller));
      merged.add(middle);
      merged.addAll(quickSort(bigger));

      return merged;
    }
  }
}
