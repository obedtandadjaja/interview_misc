import java.util.*;

public class Sorts {

  public static int[] mergeSort(int[] array) {
    if(array.length == 1) return array;
    int middle = array.length/2;
    int[] left = mergeSort(Arrays.copyOfRange(array, 0, middle));
    int[] right = mergeSort(Arrays.copyOfRange(array, middle, array.length));

    int[] merge = new int[left.length+right.length];
    int merge_i = 0;
    int left_i = 0;
    int right_i = 0;
    while(merge_i != merge.length) {
      if(left_i == left.length) {
        merge[merge_i] = right[right_i];
        merge_i++;
        right_i++;
      } else if(right_i == right.length) {
        merge[merge_i] = left[left_i];
        merge_i++;
        left_i++;
      } else if(left[left_i] < right[right_i]) {
        merge[merge_i] = left[left_i];
        merge_i++;
        left_i++;
      } else {
        merge[merge_i] = right[right_i];
        merge_i++;
        right_i++;
      }
    }
    return merge;
  }

  public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
    if(array.size() <= 1) return array;
    int middle = array.get(array.size()/2);
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < array.size(); i++) {
      if(array.get(i) < middle) {
        left.add(array.get(i));
      } else if(array.get(i) > middle) {
        right.add(array.get(i));
      }
    }
    result.addAll(quickSort(left));
    result.add(middle);
    result.addAll(quickSort(right));
    return result;
  }

  public static void main(String[] args) {
    int[] array = {5,4,3,2,1};
    array = mergeSort(array);
    for(int i = 0; i < array.length; i++)
      System.out.println(array[i]);
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(5);list.add(4);list.add(3);list.add(2);list.add(1);
    System.out.println(quickSort(list).toString());
  }
}