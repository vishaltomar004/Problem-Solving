package HomeWork.Graph_1;

public class FIndIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i<n; i++)
        {
            map.put(i , new ArrayList<>());
        }

        for(int edge[] : edges)
        {
            int u=edge[0];
            int v=edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>(); 
        boolean vis[] = new boolean[n+1];
        q.add(source);
        vis[source]=true;

        while(!q.isEmpty())
        {
            int x = q.remove();
            ArrayList<Integer> al = map.get(x);

            for(int i =0; i<al.size(); i++)
            {
                if(vis[al.get(i)]==false)
                {
                    vis[al.get(i)]=true;
                    q.add(al.get(i));
                }
            }
        }

        return vis[destination];
}
}
