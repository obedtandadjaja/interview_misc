package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.QueueAbstract;
import interview201710.DataStructures.LinkedList;

public class Queue<E> extends QueueAbstract<E> {

  public Queue() {
    this.ll = new LinkedList<E>();
  }

  public void add(E data) {
    this.ll.add(data);
  }
}
