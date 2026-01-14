class Solution {
    public int reverseBits(int n) {
        int revBitNum = 0;
        for(int i = 0, j = 31; i < 32; i++, j--) {
            int mask = 1 << i;
            if((n & mask) != 0) {
                int rMask = 1 << j;
                revBitNum = revBitNum | rMask;
            }
        }
        return revBitNum;
    }
}