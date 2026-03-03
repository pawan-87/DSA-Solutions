class Solution {
    private StringBuilder insertStr(StringBuilder str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '1' ? '0' : '1');
        }

        return sb;
    }

    public char findKthBit(int n, int k) {
        StringBuilder snStr = new StringBuilder();

        snStr.append("0");

        for(int num = 1; num <= n; num++) {
            StringBuilder invertedStr = insertStr(snStr);
            snStr.append("1");
            snStr.append(invertedStr.reverse());
        }

        return snStr.charAt(k - 1);
    }
}