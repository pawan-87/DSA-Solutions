class Solution {
    static int euclideanAlgo(int a, int b) {
        if(a == 0) {
            return b;
        }
        return euclideanAlgo(b%a, a);
    }
    
    public static int gcd(int a, int b) {
        return euclideanAlgo(a, b);
    }
}
