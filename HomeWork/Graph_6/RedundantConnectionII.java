package HomeWork.Graph_6;

import java.util.Arrays;

public class RedundantConnectionII{
    class Solution {
   
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length + 1;
    
        int[] incomingEdgeIndices = new int[n];
        Arrays.fill(incomingEdgeIndices, -1);

        int candidate1 = -1; int candidate2 = -1;
        for (int i = 0; i < n - 1; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (incomingEdgeIndices[to] == -1) {
                incomingEdgeIndices[to] = i;
            }
            else {
                candidate1 = incomingEdgeIndices[to];
                candidate2 = i;
            }
        }

        int[] parent = new int[n + 1];
        parent[0] = -1;
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        int[] candidate = null;

   
            if (candidate2 != -1 && candidate2 == i) continue;
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u, parent);
            int rootV = find(v, parent);
        
            if (rootU == rootV) {
                return candidate1 == -1? edge : edges[candidate1];
            }
            else {
                parent[v] = rootU;
            }
        }

        return edges[candidate2];

    }

    private int find(int x, int[] parent){
        if (x == parent[x]) {
            return x;
        }

        int parentX = find(parent[x], parent);
        parent[x] = parentX;
        return parentX;
    }
}

