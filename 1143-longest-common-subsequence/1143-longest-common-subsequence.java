class Solution {

    int[][] memo;

    private int LCA(int i, int j, String text1, String text2) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];  
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            return memo[i][j] = 1 + LCA(i + 1, j + 1, text1, text2);
        } else {
            int opt1 = LCA(i + 1, j, text1, text2);
            int opt2 = LCA(i, j + 1, text1, text2);
            return memo[i][j] = Math.max(opt1, opt2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        memo = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return LCA(0, 0, text1, text2);
    }
}