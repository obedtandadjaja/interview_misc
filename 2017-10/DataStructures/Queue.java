package DataStructures;

import DataStructures.abstracts.QueueAbstract;
import DataStructures.LinkedList;

import java.util.*;

public class Queue<E extends Comparable<E>> extends QueueAbstract<E> {

  public Queue() {
    this.ll = new LinkedList<E>();
  }

  public void add(E data) {
    this.ll.add(data);
  }
}
