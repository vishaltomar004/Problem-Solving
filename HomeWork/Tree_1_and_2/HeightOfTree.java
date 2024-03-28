package HomeWork.Tree_1_and_2;

public class HeightOfTree {
    public static int heightOfBinaryTree(TreeNode root) {
        // Write your code here.
         if(root==null)
    {
        return 0;
    }
    else 
    {
        return 1+ Math.max(heightOfBinaryTree(root.left) , heightOfBinaryTree(root.right));
    }
    }
}
