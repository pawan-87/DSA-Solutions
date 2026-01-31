
class RabinKarp {
    private final long mod1 = 1_000_000_007;
    private final long mod2 = 1_000_000_009;
    
    private final long base1 = 31;
    private final long base2 = 37;
    
    private long[] hash1;
    private long[] hash2;
    
    private long[] pow1;
    private long[] pow2;
    
    
    public RabinKarp(String str) {
        calculateHash(str);
    }
    
    private long charToLong(char ch) {
        return (long)(ch - 'a' + 1);    
    }
    
    private long add(long a, long b, long mod) {
        a += b;
        if(a >= mod) {
            a -= mod;
        }
        return a;
    }
    
    private long sub(long a, long b, long mod) {
        a -= b;
        if(a < 0) {
            a += mod;
        }
        return a;
    }
    
    private long multi(long a, long b, long mod) {
        return (a * b) % mod;
    }
    
    private void calculateHash(String str) {
        int n = str.length();
        
        hash1 = new long[n];
        hash2 = new long[n];
        
        pow1 = new long[n];
        pow2 = new long[n];
        
        hash1[0] = charToLong(str.charAt(0));
        hash2[0] = charToLong(str.charAt(0));
        
        pow1[0] = 1;
        pow2[0] = 1;
        
        for(int i = 1; i < n; i++) {
            hash1[i] = add(multi(hash1[i - 1], base1, mod1), charToLong(str.charAt(i)), mod1);
            pow1[i] = multi(pow1[i - 1], base1, mod1);
            
            hash2[i] = add(multi(hash2[i - 1], base2, mod2), charToLong(str.charAt(i)), mod2);
            pow2[i] = multi(pow2[i - 1], base2, mod2);
        }
    }
    
    public long[] getHash(int l, int r) {
        long hash1Val = hash1[r];
        long hash2Val = hash2[r];
        
        if(l > 0) {
            hash1Val = sub(hash1Val, multi(hash1[l - 1], pow1[r - l + 1], mod1), mod1);
            hash2Val = sub(hash2Val, multi(hash2[l - 1], pow2[r - l + 1], mod2), mod2);
        }
        
        return new long[]{hash1Val, hash2Val}; 
    }
}

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        
        RabinKarp txtHash = new RabinKarp(txt);
        RabinKarp patHash = new RabinKarp(pat);
        
        long[] patHashValues = patHash.getHash(0, m - 1);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i <= (n - m); i++) {
            long[] substrHashValues = txtHash.getHash(i, i + m - 1);
            
            if(patHashValues[0] == substrHashValues[0] && 
                    patHashValues[1] == substrHashValues[1]) {
                res.add(i);            
            }
        }
        
        return res;
    }
}