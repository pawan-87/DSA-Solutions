class Solution {
    
    private int[] constructZArray(String str) {
        int n = str.length();
        
        int[] zArray = new int[n];
        
        int l = 0, r = 0;
        
        for(int i = 1; i < n; i++) {
            if(i <= r) {
                int k = i - l;
                zArray[i] = Math.min(zArray[k], r - i + 1);
            }
            
            while((i + zArray[i]) < n && str.charAt(zArray[i]) == str.charAt(i + zArray[i])) {
                zArray[i]++;
            }
            
            if((i + zArray[i] - 1)  > r) {
                l = i;
                r = i + zArray[i] - 1;
            }
        }
        
        return zArray;
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        
        String str = pat + '$' + txt;
        
        int[] zArray = constructZArray(str);
        
        ArrayList<Integer> resIndx = new ArrayList<>();
        
        for(int i = m + 1; i < zArray.length ; i++) {
            if(zArray[i] == pat.length()) {
                resIndx.add(i - m - 1);
            }
        }
        
        return resIndx;
    }
}