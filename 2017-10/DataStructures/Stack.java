package DataStructures;

import DataStructures.abstracts.StackAbstract;
import DataStructures.LinkedList;

import java.util.*;

public class Stack<E extends Comparable<E>> extends StackAbstract<E> {

  public Stack() {
    this.ll = new LinkedList<E>();
  }

}
