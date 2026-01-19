class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];

        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int lastValidIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < s.charAt(lastValidIndex)) {
                lastValidIndex = i;
            }

            if(--count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        return s.length() == 0 ? "" : 
            s.charAt(lastValidIndex) 
                + removeDuplicateLetters(s.substring(lastValidIndex + 1).replaceAll("" + s.charAt(lastValidIndex), ""));
    }
}