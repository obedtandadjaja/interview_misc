import java.util.ArrayList;

public class AdjList {

  LinkedList[] lls;

  AdjList() {
    lls = new LinkedList[6];
    for(int i = 1; i <= 6; i++)
      lls[i-1] = new LinkedList(i);
    lls[0].add(1, 2);
    lls[0].add(2, 4);
    lls[1].add(2, 1);
    lls[1].add(4, 2);
    lls[1].add(3, 4);
    lls[2].add(4, 3);
    lls[3].add(5, 2);
    lls[4].add(3, 3);
    lls[4].add(5, 2);
    for(int i = 0; i < 6; i++)
      lls[i].print();
  }
}