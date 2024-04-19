package HomeWork.Graph_1;

public class DetectCycleiInGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
   
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
     
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, adj)) return true;
        return false;
    }
    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack,
                         ArrayList<ArrayList<Integer>> adj) {

        if (recStack[i]) return true;
        if (visited[i]) return false;
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);
      
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack, adj)) return true;
     
        recStack[i] = false;
        return false;
    }
}
