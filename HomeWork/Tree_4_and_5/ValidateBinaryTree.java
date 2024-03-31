package HomeWork.Tree_4_and_5;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class ValidateBinaryTree {
     public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root , al);
        for(int i =0; i<al.size() -1; i++)
        {
           if(al.get(i)>=al.get(i+1))
           return false;
        }
        return true;
    }

    void inOrder(TreeNode root , ArrayList<Integer> al )
    {
        if(root==null) return ;
        inOrder(root.left , al);
        al.add(root.val);
        inOrder(root.right , al);
    }
}
