package HomeWork.Graph_1;

public class MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] startCheck = new boolean[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (List<Integer> edge : edges) {
            adj.putIfAbsent(edge.get(0), new ArrayList<>());
            adj.get(edge.get(0)).add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                startCheck[i] = true;
                visited[i] = true;
                dfs(startCheck, visited, adj, i);
            }
        }
        for (int i = 0; i < startCheck.length; i++) {
            if(startCheck[i])
                res.add(i);
        }
        return res;
    }

    private static void dfs(boolean[] startCheck, boolean[] visited, HashMap<Integer, List<Integer>> adj, int node) {
        List<Integer> que = new ArrayList<>();
        que.add(node);
        while (que.size() > 0) {
            if (adj.containsKey(que.get(0))) {
                for (int i = 0; i < adj.get(que.get(0)).size(); i++) {
                    if (visited[adj.get(que.get(0)).get(i)]) {
                        if (startCheck[adj.get(que.get(0)).get(i)]) {
                            startCheck[adj.get(que.get(0)).get(i)] = false;
                        }
                    } else {
                        visited[adj.get(que.get(0)).get(i)] = true;
                        que.add(adj.get(que.get(0)).get(i));
                    }
                }
            }
            que.remove(0);
        }
    }
}
