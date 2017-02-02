import java.util.*;

// max_bikes = 100
//
// reservations
// ============
// start | end | count
// 5       10    20
// 6       9     15
// 6       9     20
// 6       9     20
// 7       8     5
//
// func accept_reservation (start Date, end Date, count Int) -> Bool

class BikeReservations {

  ArrayList<BikeReservation> reservations;
  int bikeCount;
  PriorityQueue<BikeReservation> returns;

  public static void main(String[] args) {
    BikeReservations bikeReservations = new BikeReservations(40);
    bikeReservations.reservations.add(new BikeReservation(5, 10, 10)); // 30
    bikeReservations.reservations.add(new BikeReservation(6, 9, 10)); // 20
    bikeReservations.reservations.add(new BikeReservation(6, 9, 10)); // 10
    bikeReservations.reservations.add(new BikeReservation(6, 9, 10)); // 0
    bikeReservations.reservations.add(new BikeReservation(9, 12, 10)); // 20
    bikeReservations.reservations.add(new BikeReservation(10, 12, 10)); // 20
    bikeReservations.reservations.add(new BikeReservation(13, 15, 10)); // 30
    System.out.println(bikeReservations.acceptReservation(11, 12, 20));
  }

  public BikeReservations(int bikeCount) {
    this.bikeCount = bikeCount;
    reservations = new ArrayList<>();
    returns = new PriorityQueue<BikeReservation>(BikeReservation.Comparators.END);
  }

  public boolean acceptReservation(int start, int end, int count) {
    if(count == 0 || start == end) return true;
    int index = 0;
    boolean inserted = false;
    while(index < reservations.size() || !inserted) {
      int endIndex = inserted ? reservations.get(index).start : Math.min(start, reservations.get(index).start);
      while(!returns.isEmpty() && returns.peek().end <= endIndex) {
        BikeReservation br = returns.poll();
        bikeCount += br.count;
        System.out.println("+"+br.count+" = "+bikeCount+" "+br.start+" "+br.end);
      }

      if((index == reservations.size() || start < reservations.get(index).start) && !inserted) {
        System.out.println(bikeCount);
        bikeCount -= count;
        if(bikeCount < 0) return false;
        returns.add(new BikeReservation(start, end, count));
        inserted = true;
      } else if(returns.size() == 0 || returns.peek().end > reservations.get(index).start) {
        bikeCount -= reservations.get(index).count;
        System.out.println("-"+reservations.get(index).count+" "+bikeCount);
        if(bikeCount < 0) return false;
        returns.add(reservations.get(index));
        index++;
      }
    }
    return true;
  }

  public static class BikeReservation {
    int start, end, count;
    public BikeReservation(int start, int end, int count) {
      this.start = start;
      this.end = end;
      this.count = count;
    }
    public String toString() {
      return this.start+" "+this.end+" "+this.count;
    }
    public static class Comparators {
      public static Comparator<BikeReservation> START = new Comparator<BikeReservation>() {
        @Override
        public int compare(BikeReservation br1, BikeReservation br2) {
          return br1.start-br2.start;
        }
      };
      public static Comparator<BikeReservation> END = new Comparator<BikeReservation>() {
        @Override
        public int compare(BikeReservation br1, BikeReservation br2) {
          return br1.end-br2.end;
        }
      };
    }
  }
}
