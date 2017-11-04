public class BinarySearch {

  public static void main(String[] args) {
    float[] f = {2.0f,2.1f,4.5f,4.7f,4.8f,5.0f,5.2f,6.1f,6.3f};
    System.out.println(search(f, 5));
  }

  public static int search(float[] f, int target) {
    int low = 0;
    int high = f.length-1;
    while(low <= high) {
      int middle = low+(high-low)/2;
      if(target < f[middle]) {
        high = middle-1;
      } else if(target > f[middle]) {
        low = middle+1;
      } else {
        return middle;
      }
    }
    if(Math.abs(f[low]-target) < Math.abs(f[high]-target))
      return low;
    else
      return high;
  }
}