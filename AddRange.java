import java.util.*;
import java.lang.Math;
public class AddRange {

  public static class Range {
    int start;
    int end;
    public Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
    public String toString() {
      return start+" "+end;
    }
  }

  public static void main(String[] args) {
    Range[] ranges = new Range[] {
      new Range(0,5),
      new Range(7,10),
      new Range(11,15),
      new Range(16,20),
      new Range(25,30),
      new Range(31,35)
    };
    ArrayList<Range> array = addRange(ranges, new Range(15, 21));
    for(int i = 0; i < array.size(); i++) {
      System.out.println(array.get(i).toString());
    }
  }

  public static ArrayList<Range> addRange(Range[] ranges, Range r) {
    ArrayList<Range> array = new ArrayList<>();
    boolean isAdded = false;
    for(int i = 0; i < ranges.length; i++) {
      if(r.start > ranges[i].end || isAdded) {
        array.add(ranges[i]);
      } else {
        int start = ranges[i].start;
        int end = r.end;
        for(int j = i; j < ranges.length; j++) {
          if(r.end > ranges[j].start) {
            end = Math.max(end, ranges[j].end);
          } else {
            break;
          }
          i++;
        }
        array.add(new Range(start, end));
        isAdded = true;
        i--;
      }
    }
    return array;
  }

}
