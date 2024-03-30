package HomeWork.Tree_3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PathSum2 {
      public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> bl= new ArrayList<>();
         help(root,targetSum , new ArrayList<>() , bl);
         return bl;

    }

    void help(TreeNode r , int sum , List<Integer> al , List<List<Integer>> bl)
    {
        if(r==null)
        {
            return ;
        }
        al.add(r.val);
        if(sum==r.val && r.left ==null && r.right ==null)
        {
            bl.add(al);
            return;
        }
          
          help(r.left , sum-r.val , new ArrayList<>(al) , bl);
          help(r.right , sum-r.val , new ArrayList<>(al) , bl);
         al.remove(al.size() -1);
    }
}
