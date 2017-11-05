package interview201710.stacks_queues;

import interview201710.DataStructures.*;

public class QueueViaStack {
  Stack<Integer> s1;
  Stack<Integer> s2;

  public static void main(String[] args) {
    QueueViaStack q = new QueueViaStack();
    q.add(1);
    q.add(2);
    q.add(3);
    System.out.println("inserting 1-3...");
    System.out.println("Popping: " + q.poll());
    System.out.println("Popping: " + q.poll());
    q.add(4);
    q.add(5);
    System.out.println("inserting 4-5");
    System.out.println("Popping: " + q.poll());
    System.out.println("Popping: " + q.poll());
    System.out.println("Popping: " + q.poll());
  }

  public QueueViaStack() {
    this.s1 = new Stack<Integer>();
    this.s2 = new Stack<Integer>();
  }

  public void add(int i) {
    s1.push(i);
  }

  public int poll() {
    if(s2.size() == 0)
      while(s1.size() > 0)
        s2.push(s1.pop());
    return s2.pop();
  }
}
