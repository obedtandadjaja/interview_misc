// Given a non-empty list of words, return the k most frequent elements.

// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

// Example 1:
// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
//     Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:
// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//     with the number of occurrence being 4, 3, 2 and 1 respectively.

class TopKMostFrequentWord {
    public static void main(String[] args) {
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        System.out.println(topKFrequent(words, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        Queue<String>[] pivot = (PriorityQueue<String>[])new PriorityQueue[words.length+1];

        for(String word : words) {
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if(pivot[e.getValue()] == null) pivot[e.getValue()] = new PriorityQueue<String>();
            pivot[e.getValue()].offer(e.getKey());
        }

        for(int i = pivot.length-1; i >= 0; i--) {
            if(pivot[i] != null) {
                while(pivot[i].size() > 0 && result.size() < k) {
                    result.add(pivot[i].poll());
                }
                if(result.size() == k) return result;
            }
        }

        return null;
    }
}
