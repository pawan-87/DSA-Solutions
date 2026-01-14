class Solution {

    private int getNextGrayCode(int num, Set<Integer> allGrayCodeSt) {
        for(int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int newNum = num ^ mask;

            if(!allGrayCodeSt.contains(newNum)) {
                return newNum;
            }
        }
        return -1;
    }

    public List<Integer> grayCode(int n) {
        Set<Integer> allGrayCodeSt = new HashSet<>();
        List<Integer> allGrayCode = new ArrayList<>();

        allGrayCode.add(0);
        allGrayCodeSt.add(0);
        allGrayCode.add(1);
        allGrayCodeSt.add(1);

        int num = 1;

        while(allGrayCode.size() < ((int)Math.pow(2, n))) {
            int nextGrayCodeNum = getNextGrayCode(num, allGrayCodeSt);

            allGrayCode.add(nextGrayCodeNum);
            allGrayCodeSt.add(nextGrayCodeNum);

            num = nextGrayCodeNum;
        }

        return allGrayCode;
    }
}