/*
  Difficulty: Medium

  You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

  If so, return the integer. If not, return -1.

  If there are multiple solutions, return any one.

  Example :

  Input : [1 2 3 1 1]
  Output : 1
  1 occurs 3 times which is more than 5/3 times.
*/

public class Solution {
  // DO NOT MODIFY THE LIST
  public int repeatedNumber(final List<Integer> a) {
    // It is important to note that if at a given time, you have 3 distinct element from the array,
    // if you remove them from the array, your answer does not change.

    if(a.size() == 0) return -1;
    if(a.size() == 1) return a.get(0);

    double benchmark = a.size() / 3.0;

    // keep track of 2 numbers
    int numA = a.get(0);
    int numB = a.get(1);
    int countA = 0;
    int countB = 0;

    for(int num : a) {
      if(num == numA) countA++;
      else if(num == numB) countB++;
      else if(numA == 0) { // change A if count = 0
        numA = num;
        countA = 1;
      } else if(numB == 0) { // change B if count = 0
        numB = num;
        countB = 1;
      } else { // if something other than A or B, decrement
        countA--;
        countB--;
      }
    }

    // gotta make sure that the remaining 2 nums is bigger than benchmark
    countA = 0;
    countB = 0;
    for(int num : a) {
      if(num == numA) countA++;
      else if(num == numB) countB++;
    }

    if(countA > benchmark) return numA;
    else if(countB > benchmark) return numB;

    return -1;
  }
}
