/*
  Difficulty: Medium

  N number of books are given.
  The ith book has Pi number of pages.
  You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

  NOTE: Return -1 if a valid assignment is not possible

  Input:

  List of Books
  M number of students
  Your function should return an integer corresponding to the minimum number.

  Example:

  P : [12, 34, 67, 90]
  M : 2

  Output : 113

  There are 2 number of students. Books can be distributed in following fashion :
  1) [12] and [34, 67, 90]
  Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
  Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
  Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

  Of the 3 cases, Option 3 has the minimum pages = 113.
*/

public class Solution {
  // idea is to do binarySearch on the highest value in the array and the totalSum
  public int books(ArrayList<Integer> A, int B) {
    int len = A.size();
    if(len < B) return -1;

    int total = 0;
    int max = Integer.MIN_VALUE;

    // get highest value and totalSum
    for(int i = 0; i < len; i++){
      total += A.get(i);
      max = Math.max(max, A.get(i));
    }

    // do binarySearch based on maxVal and totalSum
    int lo = max; int hi = total;
    while(lo < hi) {
      int mid = lo + (hi - lo)/2;

      // get number of readers
      int requiredReaders = getRequiredReaders(A, mid);

      // if less than B then decrease the number of pages
      // we don't return at this point so that we get the min
      // number of pages that still requires B readers
      if(requiredReaders <= B) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  private int getRequiredReaders(ArrayList<Integer> a, int maxLengthPerReader) {
    int total = 0;
    int readers = 1;

    for(int i = 0; i < a.size(); i++) {
      total += a.get(i);

      if(total > maxLengthPerReader) {
        total = a.get(i);
        readers++;
      }
    }
    return readers;
  }
}
