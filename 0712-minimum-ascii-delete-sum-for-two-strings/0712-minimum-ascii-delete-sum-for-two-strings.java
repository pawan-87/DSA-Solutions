class Solution {
    int[][] memo;

    private int minimumDeleteSumUtil(int i, int j, String s1, String s2) {
        if(i == s1.length() || j == s2.length()) {
            int restCharSum = 0;

            while(i < s1.length()) {
                restCharSum += (int) s1.charAt(i);
                i++;
            }

            while(j < s2.length()) {
                restCharSum += (int) s2.charAt(j);
                j++;
            }

            return restCharSum;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            return minimumDeleteSumUtil(i + 1, j + 1, s1, s2);
        }

        int opt1 = (int) s1.charAt(i) + minimumDeleteSumUtil(i + 1, j, s1, s2);
        int opt2 = (int) s2.charAt(j) + minimumDeleteSumUtil(i, j + 1, s1, s2);

        return memo[i][j] = Math.min(opt1, opt2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        memo = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return minimumDeleteSumUtil(0, 0, s1, s2);
    }
}