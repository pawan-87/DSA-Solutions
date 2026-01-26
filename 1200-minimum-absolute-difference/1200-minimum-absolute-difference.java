class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;

        List<List<Integer>> resList = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        for(int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if(diff == minDiff) {
                resList.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return resList;
    }
}