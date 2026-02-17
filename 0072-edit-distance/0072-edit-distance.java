class Solution {

    int[][] memo;

    private int minDistanceUtil(int i, int j, String word1, String word2) {
        if(i == word1.length() || j == word2.length()) {
            int operations = 0;

            while(i < word1.length()) {
                operations++;
                i++;
            }
            while(j < word2.length()) {
                operations++;
                j++;
            }

            return operations;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = minDistanceUtil(i + 1, j + 1, word1, word2);
        } else {
            int opt1 = Math.min(
                minDistanceUtil(i, j + 1, word1, word2),
                minDistanceUtil(i + 1, j, word1, word2)
            );

            int opt2 = minDistanceUtil(i + 1, j + 1, word1, word2);

            return memo[i][j] = (1 + Math.min(opt1, opt2));
        }
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        memo = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return minDistanceUtil(0, 0, word1, word2);
    }
}