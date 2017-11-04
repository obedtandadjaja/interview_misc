package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.QueueAbstract;
import interview201710.DataStructures.LinkedList;
import interview201710.DataStructures.LinkedListNode;

import java.util.*;

public class PriorityQueue<E extends Comparable> extends QueueAbstract<E> {

  public PriorityQueue() {
    this.ll = new LinkedList<E>();
  }

  public void add(E data) {
    LinkedListNode<E> current = this.ll.head;
    for(int i = 0; i < this.ll.size(); i++) {
      if (current.data.compareTo(data) > 0) {
        try {
          this.ll.insert(i, data);
          return;
        } catch(Exception e) {
          System.out.println(e.toString());
        }
      }
    }
    this.ll.add(data);
  }
}
