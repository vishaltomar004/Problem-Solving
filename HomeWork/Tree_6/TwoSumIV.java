package HomeWork.Tree_6;

import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class TwoSumIV {
     public boolean findTarget(TreeNode root, int k) {
        
        Set<Integer> map = new HashSet<>();
      return  in(root , k ,map);
    }

    boolean in(TreeNode root , int k , Set<Integer> set  )
    {
        if(root ==null) return  false;
         if(!set.contains(root.val))
           set.add(k-root.val);
           else {
            return true;
           }
        return in(root.left , k,set) || in(root.right , k , set) ;
       
    }
}
