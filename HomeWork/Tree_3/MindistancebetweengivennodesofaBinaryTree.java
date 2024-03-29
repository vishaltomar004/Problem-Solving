package HomeWork.Tree_3;

import java.util.ArrayList;

import org.w3c.dom.Node;

public class MindistancebetweengivennodesofaBinaryTree {
    class GfG {
          
        // first find LCS
        // fins path from LCS to a
        // find path from LCS to b , store both paths in list , return sum of size of lists-1
        
    int findDist(Node root, int a, int b) {
        // Your code here
        Node LCS=findLCS(root , a ,b);
         ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();
        
    // System.out.println("LCS = "+LCS.data);
        boolean aa = path(LCS , a , al);
        boolean bb= path(LCS , b ,bl);
        // System.out.println(al);
        // System.out.println(bl);
        return al.size()+bl.size()-2;
        
    }
    
    Node findLCS(Node root , int a , int b)
    {
        if(root==null) return root;
        if(root.data==a || root.data==b) return root;
        Node l= findLCS(root.left , a,b);
        Node r= findLCS(root.right , a,b);
        if(l==null) return r;
        if(r==null) return l;
        return root;
    }
    
    boolean path(Node root , int key ,ArrayList<Integer> al )
    {
       if(root==null) return false;
       al.add(root.data);
       
       if(root.data==key){
           return true;
       }
       
       if(path(root.left , key , al) || path(root.right , key , al))
       return true;
       
       al.remove(al.size()-1);
       return false;
       
       
       
    }
    
}
}
