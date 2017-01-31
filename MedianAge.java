import java.util.*;
public class MedianAge {
  ArrayList<Integer> ages;

  public static void main(String[] args) {
    MedianAge ma = new MedianAge();
    Scanner sc = new Scanner(System.in);
    while(true) {
      int num = sc.nextInt();
      ma.add(num);
    }
  }

  public MedianAge() {
    ages = new ArrayList<>();
  }

  public void add(int age) {
    int index = Collections.binarySearch(ages, age);
    if(index < 0) {
      index = Math.abs(index)-1;
    }
    ages.add(index, age);
    System.out.println(getMedian());
    System.out.println(ages.toString());
  }

  public double getMedian() {
    int mid = ages.size()/2;
    if(ages.size() % 2 == 1) return ages.get(mid);
    else return (ages.get(mid)+ages.get(mid-1))/2.0;
  }
}
