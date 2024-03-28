package HomeWork.Tree_1_and_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.w3c.dom.Node;

public class BottomView {
      public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
         TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0));
        
        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            Node curr = pair.node;
            int level=pair.level;
            
        
            
                map.put(level , curr.data);
            
            
            if(curr.left!=null)
            {
                q.add(new Pair(curr.left , level-1));
            }
             if(curr.right!=null)
            {
                q.add(new Pair(curr.right , level+1));
            }
        }
        
     for(Map.Entry<Integer, Integer> m : map.entrySet())
     {
         al.add(m.getValue());
     }
     return al;
    }
}
