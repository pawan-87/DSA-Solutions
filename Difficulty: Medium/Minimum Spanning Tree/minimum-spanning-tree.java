class Solution {
    private int findMinWeightedNode(boolean[] mst, int[] dist, int V) {
        int minValue = Integer.MAX_VALUE;
        int minNodeIndex = -1;
        
        for(int node = 0; node < V; node++) {
            if(mst[node] == false && dist[node] < minValue) {
                minValue = dist[node];
                minNodeIndex = node;
            }
        }
        
        return minNodeIndex;
    }
    
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adjList = constructAdjList(V, edges);
        
        boolean[] mst = new boolean[V];
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        
        dist[0] = 0;
        
        for(int count = 0; count < V - 1; count++) {
            int minWeightedNode = findMinWeightedNode(mst, dist, V);

            mst[minWeightedNode] = true;
            
            for(int[] adjNode : adjList.get(minWeightedNode)) {
                int node = adjNode[0];
                int wt = adjNode[1];
                if(mst[node] == false && dist[node] > wt) {
                    dist[node] = wt;
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < V; i++) {
            sum += dist[i];
        }
        
        return sum;
    }
    
    private List<List<int[]>> constructAdjList(int V, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v, wt;
        for(int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            wt = edge[2];
            
            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, wt});
        }
        
        return adjList;
    }
}
