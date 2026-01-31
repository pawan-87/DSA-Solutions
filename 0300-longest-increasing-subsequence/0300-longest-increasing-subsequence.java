class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lis = 1;

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            while(j >= 0) {
                if(nums[j] < nums[i] && dp[i] < (dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
                j--;
            }

            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }
}