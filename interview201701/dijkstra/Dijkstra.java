import java.util.ArrayList;

public class Dijkstra {

  int start_index;
  int last_index;
  AdjList al;

  Dijkstra(int start_index, int last_index) {
    this.start_index = start_index;
    this.last_index = last_index;
    this.al = new AdjList();
    this.al.lls[start_index].total_weight = 0;
    System.out.println(startDijkstra());
    traverse();
  }

  public int startDijkstra() {
    int curr_index = start_index;
    int open = al.lls.length;
    while(open > 0) {
      if(curr_index == -1) {
        break;
      } else {
        al.lls[curr_index].visited = true;
        open--;
        Node[] neighbors = al.lls[curr_index].getNodes();
        for(int i = 0; i < neighbors.length; i++) {
          int n_vertex = neighbors[i].vertex;
          if(al.lls[n_vertex].total_weight > (al.lls[curr_index].total_weight+neighbors[i].weight)) {
            al.lls[n_vertex].total_weight = al.lls[curr_index].total_weight+neighbors[i].weight;
            al.lls[n_vertex].from_vertex = curr_index;
            System.out.println(n_vertex+": "+al.lls[n_vertex].total_weight+" from "+curr_index);
          }
        }
      }
      curr_index = getMin(curr_index);
    }
    return al.lls[last_index].total_weight;
  }

  public void traverse() {
    for(int i = 0; i < al.lls.length; i++) {
      System.out.println("Vertex "+i+": "+al.lls[i].from_vertex+" "+al.lls[i].total_weight);
    }
    int curr = last_index;
    System.out.println(last_index);
    while(curr != start_index) {
      System.out.println(al.lls[curr].from_vertex);
      curr = al.lls[curr].from_vertex;
    }
  }

  public int getMin(int curr_index) {
    Node curr = al.lls[curr_index].head;
    int weight = Integer.MAX_VALUE;
    int n_vertex = -1;
    while(curr != null) {
      if(curr.weight < weight && !al.lls[curr.vertex].visited && al.lls[curr.vertex].length != 0) {
        weight = curr.weight;
        n_vertex = curr.vertex;
      }
      curr = curr.next;
    }
    return n_vertex;
  }

  public static void main(String[] args) {
    Dijkstra d = new Dijkstra(0, 5);
  }
}