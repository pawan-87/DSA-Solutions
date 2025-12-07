class Solution {
    public int countOdds(int low, int high) {
        int count = 0;

        if(low%2 == 0) {
            low++;
        } else {
            count++;
            low += 2;
        }

        for(int num = low; num <= high; num += 2) {
            count++;
        }

        return count;
    }
}