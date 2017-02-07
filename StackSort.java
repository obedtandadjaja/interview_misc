import java.util.*;

public class StackSort {

  public static void main(String[] args) {
    StackSort ss = new StackSort();
    ss.unsorted.push(2);
    ss.unsorted.push(5);
    ss.unsorted.push(3);
    ss.unsorted.push(1);
    ss.unsorted.push(4);
    ss.sort();
    System.out.println(ss.sorted.toString());
  }

  Stack<Integer> unsorted = new Stack<Integer>();
  Stack<Integer> sorted = new Stack<Integer>();

  public void sort() {
    while(unsorted.size() != 0) {
      int current = unsorted.pop();
      if(sorted.isEmpty()) {
        sorted.push(current);
      } else {
        if(current <= sorted.peek()) {
          sorted.push(current);
        } else {
          int counter = 0;
          while(!sorted.isEmpty() && sorted.peek() < current) {
            unsorted.push(sorted.pop());
            counter++;
          }
          sorted.push(current);
          while(counter != 0) {
            sorted.push(unsorted.pop());
            counter--;
          }
        }
      }
    }
  }

}
