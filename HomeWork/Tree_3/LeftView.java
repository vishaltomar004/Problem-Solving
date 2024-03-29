package HomeWork.Tree_3;

public class LeftView {
    
}
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.

        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        help(root , map , 0 , al);
       for(int e:al){
           System.out.print(e +" ");
       }
        
    }
     static void help(TreeNode <Integer> r, Map<Integer,Integer> map , int cl, ArrayList<Integer> al)
     {
         if(r==null)
         {
             return;
         }
         if(!map.containsKey(cl))
         {
             map.put(cl, r.data);
             al.add(r.data);
         }
          help(r.left , map , cl+1,al);
          help(r.right , map, cl+1,al);
     }
}
