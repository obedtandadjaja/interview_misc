// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

public class topKFrequent {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();

        // count[i] indicates the number of integers that appear at least i times.
        int[] count = new int[nums.length + 1];

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int t = hashmap.getOrDefault(num, 0) + 1;
            hashmap.put(num, t);
            count[t]++;
        }

        int minValue = 0; // the frequency of k-th frequent element

        int low = 0;
        int high = count.length - 1;
        int middle = (low + high) / 2;

        while(low < high) {
            if(count[middle] > k) low = middle + 1;
            else if(count[middle] < k) high = middle - 1;
            else break;
            middle = (low + high) / 2;
        }

        minValue = middle;

            // find the k most frequent elements
        for(Map.Entry<Integer, Integer> e : hashmap.entrySet()) {
            if(e.getValue() >= minValue) {
                res.add(e.getKey());
                if(res.size() == k) return res;
            }
        }

        return res;
    }
}
