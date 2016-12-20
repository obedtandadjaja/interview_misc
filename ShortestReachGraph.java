public static class Graph {
    List<List<Integer>> adjLst;
    int size;
    public Graph(int size) {
        adjLst = new ArrayList<>();
        this.size = size;
        while(size-- > 0)//Initialize the adjancency list.
            adjLst.add(new ArrayList<Integer>());
    }

    public void addEdge(int first, int second) {
        adjLst.get(first).add(second);
        adjLst.get(second).add(first);
        // For undirected graph you gotta add edges from both sides.
    }

    public int[] shortestReach(int startId) { // 0 indexed
        int[] distances = new int[size];
        Arrays.fill(distances, -1); // O(n)
        Queue<Integer> que = new LinkedList<>();

        que.add(startId); // Initialize queue.
        distances[startId] = 0;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(startId);

        while(!que.isEmpty()) { // Standard BFS loop.
            Integer curr = que.poll();
            for(int node : adjLst.get(curr)) {
                if(!seen.contains(node)) {
                    que.offer(node);
        // Right place to add the visited set.
                    seen.add(node);
        // keep on increasing distance level by level.
                    distances[node] = distances[curr] + 6;
                }
            }
        }
        return distances;
    }
}