package HomeWork.Graph_3;

public class Detectcycleinadirectedgraph {

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       // code here
       
       boolean visited[]=new boolean[V];
       boolean stack[]=new boolean[V];
       
       for(int i=0;i<adj.size();i++)
       {
           if(!visited[i])
           {
               if(iscycleutil(adj,i,visited,stack))
               {
                   return true;
               }
           }
       }
       
       return false;
   }
   
   public static boolean iscycleutil(ArrayList<ArrayList<Integer>> adj,int curr,boolean visited[], boolean stack[])
   {
       visited[curr]=true;
       stack[curr]=true;
       
       for(int i=0;i<adj.get(curr).size();i++)
       {
           int dest=adj.get(curr).get(i);
           if(stack[dest])
           {
               return true;
           }else if(!visited[dest] && iscycleutil(adj,dest,visited,stack))
           {
               return true;
           }
       }
       stack[curr]=false;
       
       return false;
   }
}
}
