package HomeWork.Tree_3;

import javax.swing.tree.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        
        help(root);
        return root;
    }

    void help(TreeNode r){
        if(r==null)
        return;
        TreeNode left = r.left;
        TreeNode right = r.right;

        r.left = right;
        r.right=left;

        help(r.left);
        help(r.right);
    }
}
