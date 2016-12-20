/**
 * Fills in the void between the numbers in the array
 */
public class MissingNumbers {
  public static void main(String[] args) {
    int[] array = {1,98};
    array = initializeArray(array);
    getMissingNumbers(array);
  }

  public static int[] initializeArray(int[] array) {
    int[] new_array = new int[array.length+2];
    new_array[0] = -1;
    for(int i = 0; i < array.length; i++) new_array[i+1] = array[i];
    new_array[new_array.length-1] = 100;
    return new_array;
  }

  public static void getMissingNumbers(int[] array) {
    for(int i = 0; i < array.length-1; i++) {
      // (1) one number in between
      if(array[i+1] - array[i] == 1) continue;
      // (2) two in between
      if(array[i+1] - array[i] == 2) System.out.println(array[i]+1);
      // (3) more than 2 numbers in between
      else if(array[i+1] - array[i] > 2) {
        System.out.println((array[i]+1)+"-"+(array[i+1]-1));
      }
    }
  }
}