package HomeWork.Tree_6;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/**
 * KthSmallestElement
 */
public class KthSmallestElement {

     static int count=0;
    public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> al = new ArrayList<>();
    in(root , k,al);    
    // System.out.println(count);
    return al.get(k-1);
    }

    void in(TreeNode r , int k, ArrayList<Integer> al)
    {
        
        if(r==null ) return;
        in(r.left , k,al);
        al.add(r.val);
        count=count+1;
        in(r.right ,k,al);
    }
}