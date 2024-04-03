package HomeWork.Tree_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Node;

public class MergeTwoBST {
     //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> al = new ArrayList<>();
          in(root1 ,al);
          in(root2 ,al);
          Collections.sort(al);
          return al;
        
        
    }
    void in(Node r, List<Integer> al) 
    {
        if(r==null)return;
        in(r.left,al);
        al.add(r.data);
        in(r.right ,al);
    }
}
