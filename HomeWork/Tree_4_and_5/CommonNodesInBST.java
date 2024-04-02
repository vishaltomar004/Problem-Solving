package HomeWork.Tree_4_and_5;

import java.util.ArrayList;
import java.util.TreeSet;

import org.w3c.dom.Node;

public class CommonNodesInBST {
    	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here
        ArrayList<Integer> al = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        // help(root1, root2 , al);
        // Collections.sort(al);
        
         help(root1 , set,al);
         help(root2, set,al);
        return al;
    }
      static void help(Node r , TreeSet<Integer> set ,ArrayList<Integer> al)
      {
          if(r==null) return ;
          
          help(r.left , set,al);
          if(set.contains(r.data)){
              al.add(r.data);
          }
          else {
              set.add(r.data);
          }
          help(r.right , set, al);
      }
}
