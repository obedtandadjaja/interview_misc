/*
Difficulty: Easy

A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles.

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.

Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)

Note:
0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
 */

import java.util.*;
import java.lang.Math;

class RobotSimulatorDistance {
  public static void main(String[] args) {
    int[] commands = new int[] { -1, 1, 2, -2, 5 };
    int[][] obstacles = null;
    robotSim(commands, obstacles);
  }

  // option 1: use 3 HashSets
  public static int robotSim(int[] commands, int[][] obstacles) {
    int x_coord = 0;
    int y_coord = 0;

    int[] x_coord_multiplier = new int[] { 0, 1, 0, -1 };
    int[] y_coord_multiplier = new int[] { 1, 0, -1, 0 };
    int direction_idx = 0;

    int max_distance = 0;

    HashSet<Integer> set_x = new HashSet<>();
    HashSet<Integer> set_y = new HashSet<>();
    HashSet<String> set = new HashSet<>();
    for(int[] obstacle : obstacles) {
      set_x.add(obstacle[0]);
      set_y.add(obstacle[1]);
      set.add(obstacle[0] + " " + obstacle[1]);
    }

    for(int command : commands) {
      if(command == -1) {
        direction_idx = (direction_idx + 1) % 4;
      } else if(command == -2) {
        direction_idx = (direction_idx + 3) % 4;
      } else {
        if(direction_idx % 2 == 0) {
          int target_y = y_coord + (command * y_coord_multiplier[direction_idx]);

          if(set_x.contains(x_coord)) {
            if(target_y > y_coord) {
              for(int i = y_coord + 1; i <= target_y; i++) {
                if(set.contains(x_coord + " " + i)) {
                  target_y = i - 1;
                  break;
                }
              }
            } else {
              for(int i = y_coord - 1; i >= target_y; i--) {
                if(set.contains(x_coord + " " + i)) {
                  target_y = i + 1;
                  break;
                }
              }
            }
          }

          y_coord = target_y;
        } else {
          int target_x = x_coord + (command * x_coord_multiplier[direction_idx]);

          if(set_y.contains(y_coord)) {
            if(target_x > x_coord) {
              for(int i = x_coord + 1; i <= target_x; i++) {
                if(set.contains(i + " " + y_coord)) {
                  target_x = i - 1;
                  break;
                }
              }
            } else {
              for(int i = x_coord - 1; i >= target_x; i--) {
                if(set.contains(i + " " + y_coord)) {
                  target_x = i + 1;
                  break;
                }
              }
            }
          }

          x_coord = target_x;
        }
      }

      max_distance = Math.max(max_distance, x_coord * x_coord + y_coord * y_coord);
    }

    return max_distance;
  }

  // option 2: use 2 maps and sort the content, then use binarySearch (not implemented)
  public static int robotSim2(int[] commands, int[][] obstacles) {
    int x_coord = 0;
    int y_coord = 0;

    int[] x_coord_multiplier = new int[] { 0, 1, 0, -1 };
    int[] y_coord_multiplier = new int[] { 1, 0, -1, 0 };
    int direction_idx = 0;

    int max_distance = 0;

    HashMap<Integer, ArrayList<Integer>> map_x = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> map_y = new HashMap<>();
    for(int[] obstacle : obstacles) {
      if(!map_x.containsKey(obstacle[0])) map_x.put(obstacle[0], new ArrayList<Integer>());
      if(!map_y.containsKey(obstacle[1])) map_y.put(obstacle[1], new ArrayList<Integer>());

      ArrayList<Integer> x_array = map_x.get(obstacle[0]);
      ArrayList<Integer> y_array = map_y.get(obstacle[1]);

      x_array.add(obstacle[1]);
      y_array.add(obstacle[0]);

      Collections.sort(x_array);
      Collections.sort(y_array);
    }

    for(int command : commands) {
      if(command == -1) {
        direction_idx = (direction_idx + 1) % 4;
      } else if(command == -2) {
        direction_idx = (direction_idx + 3) % 4;
      } else {
        if(direction_idx == 0 || direction_idx == 2) {
          int target_y = y_coord + (command * y_coord_multiplier[direction_idx]);

          if(map_x.containsKey(x_coord)) {
            ArrayList<Integer> array = map_x.get(x_coord);

            if(y_coord_multiplier[direction_idx] == 1) {
              for(int i = 0; i < array.size(); i++) {
                if(array.get(i) > y_coord && array.get(i) <= target_y) {
                  target_y = array.get(i) - 1;
                  break;
                }
              }
            } else {
              for(int i = array.size() - 1; i >= 0; i--) {
                if(array.get(i) < y_coord && array.get(i) >= target_y) {
                  target_y = array.get(i) + 1;
                  break;
                }
              }
            }
          }

          y_coord = target_y;
        } else {
          int target_x = x_coord + (command * x_coord_multiplier[direction_idx]);

          if(map_y.containsKey(y_coord)) {
            ArrayList<Integer> array = map_y.get(y_coord);

            if(x_coord_multiplier[direction_idx] == 1) {
              for(int i = 0; i < array.size(); i++) {
                if(array.get(i) > x_coord && array.get(i) <= target_x) {
                  target_x = array.get(i) - 1;
                  break;
                }
              }
            } else {
              for(int i = array.size() - 1; i >= 0; i--) {
                if(array.get(i) < x_coord && array.get(i) >= target_x) {
                  target_x = array.get(i) + 1;
                  break;
                }
              }
            }
          }

          x_coord = target_x;
        }
      }

      max_distance = Math.max(max_distance, x_coord * x_coord + y_coord * y_coord);
    }

    return max_distance;
  }
}
