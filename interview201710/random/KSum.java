import java.util.*;

class KSum {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        int k = 4;
        List<List<Integer>> list = kSum(nums, target, k);
        for(List<Integer> l : list) System.out.println(l.toString());
    }

    public static List<List<Integer>> kSum(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        
        // sorted array
        Arrays.sort(a);
        
        getKSum(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    // recursive
    public static void getKSum(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        
        // check edge cases
        if (a[start] * k > target || max * k < target) return;

        // when k = 2 do 2 pointers to find target
        if (k == 2) {
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        } else {
            for (int i = start; i < a.length - k + 1; i++) {
                // skip duplicate
                if (i > start && a[i] == a[i - 1]) continue;
                
                // when the rest will be too small for target
                if (a[i] + max * (k - 1) < target) continue;
                
                // when the rest will be too big for target
                if (a[i] * k > target) break;
                
                // case [2,2,2,2,3,4], target = 8, k = 4
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);
                    }
                    break;
                }
                path.add(a[i]);
                getKSum(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
}
