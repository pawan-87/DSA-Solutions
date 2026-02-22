class Solution {

    private int[][][] dp;

    private int solve(int pos, int count, int fp, int[] digits) {
        if(pos == digits.length) {
            return count;
        }

        if(dp[pos][count][fp] != -1) {
            return dp[pos][count][fp];
        }

        int limit;

        if(fp == 0) {
            limit = digits[pos];
        } else {
            limit = 9;
        }

        int res = 0;

        for(int digit = 0; digit <= limit; digit++) {
            int newFp = fp;
            int newCount = count;

            if(digit < limit) {
                newFp = 1;
            }

            if(digit == 1) {
                newCount++;
            }

            res += solve(pos + 1, newCount, newFp, digits);
        }

        return dp[pos][count][fp] = res;
    }

    public int countDigitOne(int n) {
        int[] digits = getDigits(n);

        dp = new int[10][10][2];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, digits);
    }

    private int[] getDigits(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        while(n > 0) {
            int digit = n%10;
            list.add(digit);
            n = n/10;
        }

        int[] digits = new int[list.size()];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = list.get(list.size() - i - 1);
        }

        return digits;
    }
}