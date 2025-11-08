// User function Template for Java

class Solution {

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        
        for(int adjNode : adjList.get(node)) {
            if(!visited[adjNode]) {
                dfs1(adjNode, adjList, visited, st);
            }
        }
        
        st.push(node);
    }
    
    private ArrayList<ArrayList<Integer>> createTransposedGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int node = 0; node < V; node++) {
            for(int adjNode : adj.get(node)) {
                adjList.get(adjNode).add(node);
            }
        }
        
        return adjList;
    }
    
    private void dfs2(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> comp) {
        visited[node] = true;
        comp.add(node);
        
        for(int adjNode : adjList.get(node)) {
            if(!visited[adjNode]) {
                dfs2(adjNode, adjList, visited, comp);
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int node = 0; node < V; node++) {
            if(!visited[node]) {
                dfs1(node, adj, visited, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> transpodedAdjList = createTransposedGraph(V, adj);
        
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        
        Arrays.fill(visited, false);
        
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!visited[node]) {
                ArrayList<Integer> currComp = new ArrayList<>();
                dfs2(node, transpodedAdjList, visited, currComp);
                Collections.sort(currComp);
                resList.add(currComp);
            }
        }
        
        Collections.sort(resList, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int minLen = Math.min(a.size(), b.size());
                for (int i = 0; i < minLen; i++) {
                    if (a.get(i) != b.get(i)) {
                        return Integer.compare(a.get(i), b.get(i));
                    }
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        
        return resList;
    }
}