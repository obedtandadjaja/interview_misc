/*
  Difficulty: Medium

  You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

  If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

  Operations allowed:

  Fill any of the jugs completely with water.
  Empty any of the jugs.
  Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
  Example 1: (From the famous "Die Hard" example)

  Input: x = 3, y = 5, z = 4
  Output: True
  Example 2:

  Input: x = 2, y = 6, z = 5
  Output: False
 */

class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if(z == x || z == y || z == x + y || z == 0) return true;
    if(z > x + y) return false;
    if(x == 0 || y == 0) return false;

    int bigger = Math.max(x, y);
    int smaller = Math.min(x, y);

    int curr = 0;
    while(curr < smaller) {
      if(smaller - ((bigger - curr) % smaller) == z) return true;
      if(smaller - ((bigger - curr) % smaller) + smaller == z) return true;
      if(smaller - ((bigger - curr) % smaller) + bigger == z) return true;

      curr = smaller - ((bigger - curr) % smaller);
    }

    return false;
  }
}
