/*
  Difficulty: Medium

  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

  The same repeated number may be chosen from candidates unlimited number of times.

  Note:

  All numbers (including target) will be positive integers.
  The solution set must not contain duplicate combinations.
  Example 1:

  Input: candidates = [2,3,6,7], target = 7,
  A solution set is:
  [
  [7],
  [2,2,3]
  ]
  Example 2:

  Input: candidates = [2,3,5], target = 8,
  A solution set is:
  [
  [2,2,2,2],
  [2,3,3],
  [3,5]
  ]
 */

class Solution {
  // approach 1: no sorting, just avoid duplication by passing start index
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> curr = new LinkedList<>();

    findCombinations(result, candidates, 0, target, curr);

    return result;
  }

  public void findCombinations(
    List<List<Integer>> result,
    int[] candidates,
    int index,
    int target,
    LinkedList<Integer> curr
  ) {
    if(target < 0) return;
    if(target == 0) result.add((LinkedList) curr.clone());

    for(int i = index; i < candidates.length; i++) {
      curr.add(candidates[i]);
      findCombinations(result, candidates, i, target - candidates[i], curr);
      curr.removeLast();
    }
  }

  // approach 2: sort and do binary search and iterate backwards
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> curr = new LinkedList<>();

    Arrays.sort(candidates);
    findCombinations(result, candidates, candidates.length - 1, target, curr);

    return result;
  }

  public void findCombinations(
    List<List<Integer>> result,
    int[] candidates,
    int max_index,
    int target,
    LinkedList<Integer> curr
  ) {
    if(target == 0) {
      // result.add((LinkedList) curr.clone());
      result.add(new ArrayList<>(curr));
      return;
    }
    if(target < 0 || target < candidates[0]) return;

    for(int i = binarySearch(candidates, target, max_index); i >= 0; i--) {
      curr.add(candidates[i]);
      findCombinations(result, candidates, i, target - candidates[i], curr);
      curr.removeLast();
    }
  }

  public int binarySearch(int[] candidates, int target, int max_index) {
    if(target < candidates[0]) return -1;
    if(max_index == 0) return max_index;

    int start = 0;
    int end = max_index;
    int mid;
    while(start <= end) {
      mid = (start + end) / 2;

      if(candidates[mid] < target) {
        start = mid + 1;
      } else if(candidates[mid] > target) {
        end = mid - 1;
      } else {
        return mid;
      }
    }

    return end;
  }
}
