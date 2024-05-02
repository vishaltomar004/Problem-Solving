package HomeWork.Graph_3;

public class LargestColorValueinaDirectedGraph {
    
class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        Graph graph = new Graph(edges, colors);

        int result = 0;

        boolean[] visited = new boolean[graph.len()];
        for(int i = 0; i < graph.len(); i++) {
            if(dfs(i, graph, visited)) return -1;
            result = Math.max(result, graph.recallMax(i));
        }

        return result;
    }

    private boolean dfs(int from, Graph graph, boolean[] visited) {
        if(visited[from]) return true;
        visited[from] = true;

        if(graph.isNotMemorized(from)) {
            int[] memory = graph.recall(from);
            for (int next : graph.neighbors(from)) {
                if (dfs(next, graph, visited)) return true;
                int[] nextMem = graph.recall(next);
                for (int i = 0; i < 26; i++) {
                    memory[i] = Math.max(nextMem[i], memory[i]);
                }
            }
            memory[graph.color(from)]++;
        }

        visited[from] = false;
        return false;
    }

    private static class Graph {
        Map<Integer, Set<Integer>> connections;
        int[][] memory;
        String colors;

        Graph(int[][] edges, String colors) {
            this.colors = colors;
            this.connections = new HashMap<>();
            this.memory = new int[len()][];
            for(int i = 0; i < len(); i++) {
                this.connections.put(i, new HashSet<>());
            }
            for(int[] edge : edges) {
                this.connections.get(edge[0]).add(edge[1]);
            }
        }

        int len() {
            return colors.length();
        }

        Set<Integer> neighbors(int node) {
            return connections.get(node);
        }

        int[] recall(int node) {
            if(isNotMemorized(node)) {
                memory[node] = new int[26];
            }
            return memory[node];
        }

        int recallMax(int node) {
            int max = -1;
            for(int v : recall(node)) {
                max = Math.max(v, max);
            }
            return max;
        }

        boolean isNotMemorized(int node) {
            return memory[node] == null;
        }

        int color(int node) {
            return colors.charAt(node) - 'a';
        }
    }
}

}
