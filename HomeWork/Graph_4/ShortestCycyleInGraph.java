package HomeWork.Graph_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestCycyleInGraph {
    class Solution {
    int min = Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(adj, new HashSet<Integer>(), i);
        }

        return min == Integer.MAX_VALUE ? - 1 : min;
    }

    void dfs(List<List<Integer>> adj, Set<Integer> set, int node) {

        Queue<int[]> queue = new LinkedList<>();
        set.add(node);
        int level = 1;
        queue.add(new int[] {node, node});

        int[] distance = new int[adj.size()];
        Arrays.fill(distance, -1);
        distance[node] = 0;

        while (!queue.isEmpty()) {
            
            int[] arr = queue.poll();
            int topNode = arr[0];
            int  from = arr[1];
            

            for  (int i : adj.get(topNode)) {
                if (i == from)
                    continue;
                if (set.contains(i)) {
                    min = Math.min(min, distance[topNode] + distance[i] + 1);
                    continue;
                }

                set.add(i);
                distance[i] = distance[topNode] + 1;
                queue.add(new int[] {i, topNode});

            }
        }
    }
}
}
