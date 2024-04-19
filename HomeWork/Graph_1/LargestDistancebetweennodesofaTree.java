package HomeWork.Graph_1;

public class LargestDistancebetweennodesofaTree {
    int ans;
    public int solve(ArrayList<Integer> A) {
        ans = Integer.MIN_VALUE;
        int n = A.size();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int root = 0;
        if(n==1) return 0;

        for(int i=0; i<n; i++)
        {
            if(A.get(i)==-1) root=i;
            else
            {
                adj.putIfAbsent(A.get(i), new ArrayList<>());
                adj.get(A.get(i)).add(i);
            }
        }

        dfs(root, adj);
        return ans;

    }

    public int dfs(int root, Map<Integer, List<Integer>> adj)
    {
        if(adj.get(root)==null) return 1;

        List<Integer> neigh = adj.get(root);
        int n = neigh.size();
        for(int i=0; i<n; i++)
        {
            neigh.set(i, dfs(neigh.get(i), adj));
        }

        Collections.sort(neigh, Collections.reverseOrder());

 
        if(n>1)
        {
            ans = Math.max(ans, neigh.get(0)+neigh.get(1)); 
        }
        else ans = Math.max(ans, neigh.get(0));
       
        return 1 + neigh.get(0);
       
    }
}
