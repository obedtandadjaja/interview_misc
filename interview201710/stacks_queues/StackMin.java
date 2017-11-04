package interview201710.stacks_queues;

import interview201710.DataStructures.*;

public class StackMin extends Stack<Integer> {
  public Stack<Integer> min;

  public static void main(String[] args) {
    StackMin minStack = new StackMin();
    minStack.push(5);
    minStack.push(4);
    minStack.push(3);
    minStack.push(-1);
    minStack.push(1);
    minStack.push(2);

    System.out.println("5,4,3,-1,1,2: " + minStack.min());
    minStack.pop();
    System.out.println("5,4,3,-1,1: " + minStack.min());
    minStack.pop();
    System.out.println("5,4,3,-1: " + minStack.min());
    minStack.pop();
    System.out.println("5,4,3: " + minStack.min());
  }

  public StackMin() {
    min = new Stack<Integer>();
  }

  public void push(int i) {
    super.push(i);
    if(i <= min()) min.push(i);
  }

  public Integer pop() {
    int returnValue = super.pop();
    if(returnValue == min()) min.pop();
    return returnValue;
  }

  public int min() {
    return min.size() > 0 ? min.peek() : Integer.MAX_VALUE;
  }
}
