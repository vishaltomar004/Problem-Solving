package HomeWork.Tree_3;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
        {
            return root;
        }

        if(root==p || root ==q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left , p,q);
        TreeNode right = lowestCommonAncestor(root.right , p,q);

        if(left ==null)
        return right;
        if(right==null)
        return left;

        return root;
    }
}
