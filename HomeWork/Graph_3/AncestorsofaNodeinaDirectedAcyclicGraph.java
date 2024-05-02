package HomeWork.Graph_3;

public class AncestorsofaNodeinaDirectedAcyclicGraph {
    class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            ArrayList<Integer>[] graph = new ArrayList[n];
            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                graph[i] = new ArrayList<>();
                ans.add(new ArrayList<>());
            }
    
            for(int i = 0; i < edges.length; i++){
                graph[edges[i][0]].add(edges[i][1]);
            }
    
            for(int i = 0; i < n; i++){
                dfs(graph, new boolean[n], i, i, ans);
            }
            return ans;
        }
    
        public void dfs(ArrayList<Integer>[] graph, boolean[] visited, int uParent, int src, List<List<Integer>> ans){
            visited[src] = true;
    
            for(int nbr : graph[src]){
                if(!visited[nbr]){
                    ans.get(nbr).add(uParent);
                    dfs(graph, visited, uParent, nbr, ans);
                }
            }
        }
    }
}
