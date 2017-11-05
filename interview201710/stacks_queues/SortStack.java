package interview201710.stacks_queues;

import interview201710.DataStructures.*;

public class SortStack {
  Stack<Integer> s;
  Stack<Integer> buffer;

  public static void main(String[] args) {
    SortStack ss = new SortStack();

    System.out.println("inserting 1-5");
    ss.push(1);
    ss.push(2);
    ss.push(3);
    ss.push(4);
    ss.push(5);

    System.out.println("peek: " + ss.peek());
    System.out.println("pop: " + ss.pop());
    System.out.println("pop: " + ss.pop());
    System.out.println("pop: " + ss.pop());
    System.out.println("pop: " + ss.pop());
    System.out.println("pop: " + ss.pop());
    System.out.println("isEmpty: " + ss.isEmpty());
  }

  public SortStack() {
    s = new Stack<Integer>();
    buffer = new Stack<Integer>();
  }

  public void push(int i) {
    while(s.size() > 0 && i > s.peek())
      buffer.push(s.pop());

    s.push(i);

    if(buffer.size() > 0)
      while(buffer.size() > 0)
        s.push(buffer.pop());
  }

  public int pop() {
    return s.pop();
  }

  public int peek() {
    return s.peek();
  }

  public boolean isEmpty() {
    return s.size() == 0;
  }
}
