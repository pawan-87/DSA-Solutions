class Solution {
    
    private int dfs(int node, int destNode, ArrayList<ArrayList<int[]>> adjList, int maxTime, boolean[] visited) {
        if(maxTime < 0) {
            return 0;
        }
        
        if(maxTime == 0 && node == destNode) {
            return 1;
        }
        
        int count = 0;
        
        visited[node] = true;
        
        int adj, time;
        for(int[] adjNode : adjList.get(node)) {
            adj = adjNode[0];
            time = adjNode[1];
            
            if(!visited[adj]) {
                count += dfs(adj, destNode, adjList, maxTime - time, visited);
            }
        }
        
        visited[node] = false;
        
        return count;
    }
    
    public int countPaths(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = constructAdjList(V, edges);
        
        int maxTime = minDist(0, V - 1, V, adjList);
        
        boolean[] visited = new boolean[V];
        
        int count = dfs(0, V-1, adjList, maxTime, visited);
        
        return count;
    }
    
    private int minDist(int src, int dest, int V, ArrayList<ArrayList<int[]>> adjList) {
        Queue<Integer> bfs = new LinkedList<>();
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs.add(src);
        dist[src] = 0;
        
        while(!bfs.isEmpty()) {
            int currNode = bfs.poll();
            
            if(currNode == dest) {
                continue;
            }
            
            for(int[] adjNode : adjList.get(currNode)) {
                int adj = adjNode[0];
                int time = adjNode[1];
                
                if(dist[adj] > (dist[currNode] + time)) {
                    dist[adj] = dist[currNode] + time;
                    bfs.add(adj);
                }
            }
        }
        
        return dist[dest];
    }
    
    private ArrayList<ArrayList<int[]>> constructAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        
        for(int node = 0; node < V; node++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v, t;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1]; t = edge[2];
            adjList.get(u).add(new int[]{v, t});
            adjList.get(v).add(new int[]{u, t});
        }
        
        return adjList;
    }
}
