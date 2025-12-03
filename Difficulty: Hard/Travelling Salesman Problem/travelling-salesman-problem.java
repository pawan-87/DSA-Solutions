class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        if (n <= 1) return n == 1 ? cost[0][0] : 0;
        
        final int INF = Integer.MAX_VALUE;
        int FULL = 1 << n, fullMask = FULL - 1;

        int[][] dp = new int[FULL][n];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[1][0] = 0;
        
        for (int mask = 1; mask < FULL; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) continue;
                if (dp[mask][i] == INF) continue;
                
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0) continue;
                    
                    int nxt = mask | (1 << j);
                    dp[nxt][j] = Math.min(dp[nxt][j], 
                                    dp[mask][i] + cost[i][j]);
                }
            }
        }
        
        int ans = INF;
        for (int i = 0; i < n; i++) {
            if (dp[fullMask][i] != INF) {
                ans = Math.min(ans, dp[fullMask][i] + cost[i][0]);
            }
        }
        
        return ans;
    }
}