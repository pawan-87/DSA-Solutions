class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = constructAdjList(V, edges);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a[1], b[1]));
        boolean[] mst = new boolean[V];
        int[] val = new int[V];
        
        Arrays.fill(val, Integer.MAX_VALUE);
        
        int src = 0;
        
        minHeap.add(new int[]{src, 0});
        val[src] = 0;
        
        while(!minHeap.isEmpty()) {
            int[] currNode = minHeap.poll();
            
            int node = currNode[0];
            
            if(mst[node]) {
                continue;
            }
            
            mst[node] = true;
            
            for(int[] adjNode : adjList.get(node)) {
                int v = adjNode[0];
                int wt = adjNode[1];
                
                if(mst[v] == false && val[v] >  wt) {
                    val[v] = wt;
                    minHeap.add(new int[]{v, val[v]});
                }
            }
        }
        
        int sum = 0;
        for(int node = 0; node < V; node++) {
            sum += val[node];
        }
        
        return sum;
    }
    
    static ArrayList<ArrayList<int[]>> constructAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v, wt;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1]; wt = edge[2];
            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, wt});
        }
        
        return adjList;
    }
}
