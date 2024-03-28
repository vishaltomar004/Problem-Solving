package HomeWork.Tree_1_and_2;


 class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
         this.left = left;
            this.right = right;
         }
 }
    
public class Maximum_depth_of_Binary_tree {
    // Nothing just I am returnig My depth else recursion is taking care of

    public int maxDepth(TreeNode root) {
          if(root==null)
           return 0;

           if(root.left==null && root.right==null)
           return 1;
               else
           return 1+ Math.max(maxDepth(root.left) , maxDepth(root.right) );
        
    }
}
