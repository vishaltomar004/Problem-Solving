package HomeWork.Tree_1_and_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_Level_Order_Traversal {

    // Levele order traversal using queue
    // checking left right of top element in queue , storing them and removing current
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> badiList = new ArrayList<>();
        if(root==null)
        return badiList;
         q.add(root);

         while(!q.isEmpty())
         {
            ArrayList<Integer> chotiList  = new ArrayList<>();;
            int x= q.size();
            for(int i =0; i<x; i++){
             TreeNode popped = q.poll();
             chotiList.add(popped.val);
             if(popped.left!=null)
             {
                q.add(popped.left);
             }
             if(popped.right!=null)
             {
                q.add(popped.right);
             }
            }

            badiList.add(chotiList);
         }
          
       return badiList;
    }
}
