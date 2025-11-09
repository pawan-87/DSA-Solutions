class Solution {
    private int countOperationsUtil(int num1, int num2) {
        if(num1 == 0 || num2 == 0) {
            return 0;
        }
        
        if(num1 >= num2) {
            return 1 + countOperationsUtil(num1 - num2, num2);
        } else {
            return 1 + countOperationsUtil(num1, num2 - num1);
        }
    }

    public int countOperations(int num1, int num2) {
        return countOperationsUtil(num1, num2);
    }
}