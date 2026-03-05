class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int operation1 = 0;
        for(int i = 1; i < n; i += 2) {
            if(!(s.charAt(i - 1) == '0' && s.charAt(i) == '1')) {
                if(s.charAt(i - 1) != '0') {
                    operation1++;
                }
                if(s.charAt(i) != '1') {
                    operation1++;
                }
            }
        }
        if(n%2 != 0 && s.charAt(n - 1) != '0') {
            operation1++;
        }

        int operation2 = 0;
        for(int i = 1; i < n; i += 2) {
            if(!(s.charAt(i - 1) == '1' && s.charAt(i) == '0')) {
                if(s.charAt(i - 1) != '1') {
                    operation2++;
                }
                if(s.charAt(i) != '0') {
                    operation2++;
                }
            }
        }
        if(n%2 != 0 && s.charAt(n - 1) != '1') {
            operation2++;
        }

        return Math.min(operation1, operation2);
    }
}