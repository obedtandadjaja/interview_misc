public class Solution {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> result = new ArrayList();

    helper(A, result, 0);

    return result;
  }

  // idea here is that permutation is simply rotating around indexes
  // [1,2,3]
  // [1,3,2]
  // [2,1,3]
  // [2,3,1]
  // [3,1,2]
  // [3,2,1]
  public void helper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int index) {
    if(index >= A.size()) {
      result.add(new ArrayList(A));
      return;
    }

    // first iteration will not do anything since i == index
    // see first permutation [1,2,3]
    // subsequently, 1 will be swapped with 2 and 3
    for(int i = index; i < A.size(); i++) {
      Collections.swap(A, index, i);
      helper(A, result, index + 1);
      Collections.swap(A, index, i);
    }
  }
}
