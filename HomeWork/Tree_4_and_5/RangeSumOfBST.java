package HomeWork.Tree_4_and_5;

import javax.swing.tree.TreeNode;

public class RangeSumOfBST {
     public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root==null) return 0;

        if(root.val <= high && root.val >=low )
        {
            return root.val + rangeSumBST(root.left , low, high) +
             rangeSumBST(root.right , low, high);
        }

        else if(root.val > high)
        {
            return rangeSumBST(root.left , low, high);
        }

        else if (root.val <  low ){

        return rangeSumBST(root.right , low, high) ;
        
        }
           return root.val;
    }
}
