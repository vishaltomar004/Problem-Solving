package HomeWork.Tree_4_and_5;

public class LargestBST {
    
}

class Pairs{
    int nodeCount;
    int maxValue;
    int minValue;
    
    Pairs(int nodeCount ,int minValue ,int maxValue)
    {
        this. nodeCount= nodeCount;
        this. maxValue= maxValue;
        this. minValue= minValue;
    }
}
class Solution{
    static int max=Integer.MAX_VALUE;
     static int min=Integer.MIN_VALUE;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        Pairs p = help(root);
        return p.nodeCount;
    
        
    }
    
    static Pairs help(Node root)
    {
        if(root ==null)  return new Pairs(0 ,max, min );
        
        Pairs left = help(root.left);
        Pairs right =help(root.right);
         
         if(root.data > left.maxValue && root.data < right.minValue)
         {
             return new Pairs(1+left.nodeCount + right.nodeCount , Math.min(root.data , left.minValue) , Math.max(root.data, right.maxValue));
         }
         
         else 
         return new Pairs(Math.max(left.nodeCount ,right.nodeCount),min,max);

    }
    
}