/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution {
    int diameterVal;
    
    private int diameterUtil(Node root) {
        if(root == null) {
            return 0;
        }
        
        int leftDepth = diameterUtil(root.left);
        int rightDepth = diameterUtil(root.right);
        
        int currentDiameter = leftDepth + rightDepth + 1;
        
        diameterVal = Math.max(diameterVal, currentDiameter);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    public int diameter(Node root) {
        diameterVal = 0;
        
        diameterUtil(root);
        
        return diameterVal - 1;
    }
}