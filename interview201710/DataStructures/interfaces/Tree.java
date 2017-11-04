package interview201710.DataStructures.interfaces;

public interface Tree<E> {
  public void add(E data);
  public void delete(E data);
  public int size();
  public String toString();
}
