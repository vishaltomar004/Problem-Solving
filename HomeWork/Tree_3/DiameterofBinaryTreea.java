package HomeWork.Tree_3;

import javax.swing.tree.TreeNode;

public class DiameterofBinaryTreea {
     public int diameterOfBinaryTree(TreeNode root) {
      int maxi[]=new int[1];
      int x = help(root , maxi);
     return maxi[0];
    }

    int help(TreeNode r, int maxi[])
    {
        if(r==null)
        {
            return 0;
        }
        int l = help(r.left , maxi);
          int rm= help(r.right , maxi);
        maxi[0]=Math.max(maxi[0] , l+rm);

        return 1+Math.max(l, rm);
        
    }
}
