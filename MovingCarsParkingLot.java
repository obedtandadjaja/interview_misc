import java.lang.Math;
import java.util.*;

public class MovingCarsParkingLot {

  // Test cases
  //
  // 1 2 3 -1 4 5
  // 1 2 -1 3 4 5
  // 1 2 5 3 4 -1
  // 1 2 5 3 -1 4
  // 1 -1 5 3 2 4
  // -1 1 5 3 2 4
  // 5 1 -1 3 2 4
  // 6 steps
  //
  // 1 2 3 -1 4 5
  // -1 2 3 1 4 5
  // 5 2 3 1 4 -1
  // 5 2 3 1 -1 4
  // 5 -1 3 1 2 4
  // 5 1 3 -1 2 4
  // 5 1 -1 3 2 4
  // 6 steps
  //
  // 1 2 3 -1 4 5
  // 1 -1 3 2 4 5
  // -1 1 3 2 4 5
  // 5 1 3 2 4 -1
  // 5 1 3 2 -1 4
  // 5 1 3 -1 2 4
  // 5 1 -1 3 2 4
  // 6 steps
  //
  // 1 2 3 -1 4 5
  // 1 2 3 4 -1 5
  // 1 -1 3 4 2 5
  // -1 1 3 4 2 5
  // 5 1 3 4 2 -1
  // 5 1 3 -1 2 4
  // 5 1 -1 3 2 4
  // 6 steps
  //
  // 1 2 3 -1 4 5
  // 1 2 3 5 4 -1
  // 1 2 3 5 -1 4
  // 1 -1 3 5 2 4
  // -1 1 3 5 2 4
  // 5 1 3 -1 2 4
  // 5 1 -1 3 2 4
  // 6 steps
  //
  // 1 2 3 -1 4 5
  // 1 2 3 5 4 -1
  // 1 -1 3 5 4 2
  // -1 1 3 5 4 2
  // 5 1 3 -1 4 2
  // 5 1 3 4 -1 2
  // 5 steps

  public static void main(String[] args) {
    int[] array = {1,2,3,-1,4,5};
    int[] result = {5,1,2,4,-1,3};
    System.out.println(getSteps(array, result).toString());
  }

  public static ArrayList<Integer> getSteps(int[] array, int[] result) {
    if(array == null || result == null) return null;
    ArrayList<Integer> steps = new ArrayList<>();
    HashMap<Integer, Integer> map = getCarSlotMap(array, result);
    if(map.size() == 0) return null;
    int emptySpotIndex = findIndex(array, -1);
    while(map.size() != 0) {
      if(result[emptySpotIndex] != -1) {
        int indexToMove = map.get(result[emptySpotIndex]);
        map.remove(result[emptySpotIndex]);
        steps.add(array[indexToMove]);
        emptySpotIndex = indexToMove;
      } else {
        int indexToMove = map.keySet().iterator().next();
        steps.add(array[indexToMove]);
        int newEmptySpotIndex = map.get(indexToMove);
        map.put(indexToMove, emptySpotIndex);
        emptySpotIndex = newEmptySpotIndex;
      }
    }
    return steps;
  }

  public static HashMap<Integer, Integer> getCarSlotMap(int[] array, int[] result) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < array.length; i++) {
      if(array[i] != -1 && array[i] != result[i]) {
        map.put(array[i], i);
      }
    }
    return map;
  }

  public static int findIndex(int[] array, int num) {
    for(int i = 0; i < array.length; i++)
      if(array[i] == num) return i;
    return -1;
  }

}
