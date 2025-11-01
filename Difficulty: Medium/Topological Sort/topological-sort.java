class Solution {
    private void dfs(int currNode, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> st) {
        visited[currNode] = true;
        
        for(int adjNode : adjList.get(currNode)) {
            if(!visited[adjNode]) {
                dfs(adjNode, adjList, visited, st);
            }
        }
        
        st.add(currNode);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = constructAdjList(V, edges);
        
        ArrayList<Integer> toposort = new ArrayList<>();
        
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(0, adjList, visited, st);
            }
        }
        
        while(!st.isEmpty()) {
            toposort.add(st.pop());
        }
        
        return toposort;
    }
    
    private List<List<Integer>> constructAdjList(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1];
            adjList.get(u).add(v);
        }
        
        return adjList;
    }
}