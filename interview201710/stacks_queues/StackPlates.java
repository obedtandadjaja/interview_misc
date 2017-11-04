package interview201710.stacks_queues;

import interview201710.DataStructures.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class StackPlates extends Stack<Integer> {
  private int capacity = 5;
  private ArrayList<Stack<Integer>> stacks;

  public static void main(String[] args) {
    StackPlates stackOfPlates = new StackPlates();
    stackOfPlates.push(9);
    stackOfPlates.push(8);
    stackOfPlates.push(7);
    stackOfPlates.push(6);
    stackOfPlates.push(5);
    stackOfPlates.push(4);
    stackOfPlates.push(3);
    stackOfPlates.push(2);
    stackOfPlates.push(1);
    stackOfPlates.push(0);

    System.out.println(stackOfPlates.toString());

    stackOfPlates.pop();
    stackOfPlates.pop();

    System.out.println(stackOfPlates.toString());

    stackOfPlates.pop();
    stackOfPlates.pop();
    stackOfPlates.pop();

    System.out.println(stackOfPlates.toString());

    stackOfPlates.pop();
    stackOfPlates.pop();
    stackOfPlates.pop();

    System.out.println(stackOfPlates.toString());
  }

  public StackPlates() {
    stacks = new ArrayList<Stack<Integer>>();
  }

  public StackPlates(int capacity) {
    this.capacity = capacity;
    stacks = new ArrayList<Stack<Integer>>();
  }

  public void push(Integer i) {
    if(stacks.size() == 0 || stacks.get(stacks.size()-1).size() == capacity)
      stacks.add(new Stack<Integer>());
    stacks.get(stacks.size()-1).push(i);
  }

  public Integer pop() {
    if(stacks.size() == 0) return null;
    int returnValue = stacks.get(stacks.size()-1).pop();
    if(stacks.get(stacks.size()-1).size() == 0) stacks.remove(stacks.size()-1);
    return returnValue;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < stacks.size(); i++) {
      sb.append("[");
      sb.append(stacks.get(i).toString());
      sb.append("], ");
    }
    return sb.toString();
  }
}
