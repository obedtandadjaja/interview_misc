import java.util.*;

public class StackSort {

  public static void main(String[] args) {
    StackSort ss = new StackSort();
    ss.unsorted.push(2);
    ss.unsorted.push(5);
    ss.unsorted.push(3);
    ss.unsorted.push(1);
    ss.unsorted.push(4);
    ss.sortASC();
    System.out.println(ss.sorted.toString());
  }

  Stack<Integer> unsorted = new Stack<Integer>();
  Stack<Integer> sorted = new Stack<Integer>();

  public void sortDSC() {
    while(unsorted.size() != 0) {
      int temp = unsorted.pop();
      while(!sorted.isEmpty() && sorted.peek() < temp) {
        unsorted.push(sorted.pop());
      }
      sorted.push(temp);
    }
  }

  public void sortASC() {
    while(!unsorted.isEmpty()) {
      int temp = unsorted.pop();
      while(!sorted.isEmpty() && sorted.peek() > temp) {
        unsorted.push(sorted.pop());
      }
      sorted.push(temp);
    }
  }

}
