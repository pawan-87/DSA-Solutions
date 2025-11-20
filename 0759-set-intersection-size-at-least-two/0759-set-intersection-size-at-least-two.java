class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int ans = 0;
        int a = -1, b = -1;

        for(int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if(left > b) {
                a = right - 1;
                b = right;
                ans += 2;
            } else if(left > a) {
                a = b;
                b = right;
                ans += 1;
            }
        }

        return ans;
    }
}