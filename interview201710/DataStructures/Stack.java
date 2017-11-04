package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.StackAbstract;
import interview201710.DataStructures.LinkedList;

import java.util.*;

public class Stack<E> extends StackAbstract<E> {

  public Stack() {
    this.ll = new LinkedList<E>();
  }

}
