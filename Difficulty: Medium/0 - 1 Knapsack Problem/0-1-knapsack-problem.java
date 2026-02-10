class Solution {
    
    private int knapsackUtil(int i, int W, int[] val, int[] wt, int[][] memo) {
        if(i >= val.length) {
            return 0;
        }
        
        if(memo[i][W] != -1) {
            return memo[i][W];
        }
        
        int opt1 = 0, opt2 = 0;
        
        if(wt[i] <= W) {
            opt1 = val[i] + knapsackUtil(i + 1, W - wt[i], val, wt, memo);
        }
        
        opt2 = knapsackUtil(i + 1, W, val, wt, memo);
        
        return memo[i][W] = Math.max(opt1, opt2);
    }
    
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        int[][] memo = new int[n][W + 1];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return knapsackUtil(0, W, val, wt, memo);
    }
}
