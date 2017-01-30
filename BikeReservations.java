import java.io.*;
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

  static ArrayList<BikeReservation> reservations;

  public static void main(String[] args) {
    reservations = new ArrayList<BikeReservation>();
    reservations.add(new BikeReservation(5, 10, 20));
    reservations.add(new BikeReservation(6, 9, 15));
    reservations.add(new BikeReservation(6, 9, 1));
    reservations.add(new BikeReservation(6, 9, 1));
    reservations.add(new BikeReservation(7, 8, 2));
    System.out.println(acceptReservation(6, 9, 1));
  }

  public static boolean acceptReservation(int start, int end, int count) {
    reservations.add(new BikeReservation(start, end, count));
    Collections.sort(reservations, BikeReservation.Comparators.START);
    System.out.println(reservations.toString());
    int currentBikeCount = 40;
    int currentLowestEnd = Integer.MAX_VALUE;
    ArrayList<BikeReservation> returns = new ArrayList<BikeReservation>();
    for(int i = 0; i < reservations.size(); i++) {
      BikeReservation reservation = reservations.get(i);
      if(currentBikeCount >= reservation.count) {
        currentBikeCount -= reservation.count;
        currentLowestEnd = Math.min(currentLowestEnd, reservation.end);
        returns.add(reservation);
        while(i+1 < reservations.size() && i+1 < currentLowestEnd) {
          reservation = reservations.get(i+1);
          if(currentBikeCount >= reservation.count) {
            currentBikeCount -= reservation.count;
            currentLowestEnd = Math.min(currentLowestEnd, reservation.end);
            returns.add(reservation);
            i++;
          } else {
            return false;
          }
        }
        for(int j = 0; j < returns.size(); j++) {
          BikeReservation returnReservation = returns.get(j);
          currentBikeCount += returnReservation.count;
        }
      } else {
        return false;
      }
      currentLowestEnd = Integer.MAX_VALUE;
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
    }
  }
}
