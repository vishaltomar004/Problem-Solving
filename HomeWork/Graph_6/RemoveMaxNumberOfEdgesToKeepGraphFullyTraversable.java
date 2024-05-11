package HomeWork.Graph_6;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        var alice = new UF(n);
        var bob = new UF(n);

        var remainigEdges = edges.length;
        // avoid sorting by type desc, iterate for type 3
        for (var e : edges) {
            if (e[0] == 3 && (alice.union(e[1], e[2]) | bob.union(e[1], e[2])))
                --remainigEdges;
        }
        
        // for type 1 and 2 union in any order
        for (var e : edges) {
            if (e[0] == 2 && bob.union(e[1], e[2]))
                --remainigEdges;
            else if (e[0] == 1 && alice.union(e[1], e[2]))
                --remainigEdges;
        }
        
        if (!bob.isConnected() || !alice.isConnected())
            return -1;

        return remainigEdges;
    }
}

class UF {

    private final int[] id, rank;
    private int count;

    UF(int N) {
        this.id = new int[N + 1];
        this.rank = new int[N + 1];
        this.count = N;

        for (var i = 1; i <= N; ++i)
            id[i] = i;
    }

    boolean union(int p, int q) {
        var pId = find(p);
        var qId = find(q);

        if (pId == qId)
            return false;

        if (rank[pId] < rank[qId])
            id[pId] = qId;
        else if (rank[pId] > rank[qId])
            id[qId] = pId;
        else {
            id[qId] = pId;
            rank[pId]++;
        }

        --count;

        return true;
    }

    private int find(int p) {
        while (p != id[p])
            p = id[p];

        return p;
    }

    boolean isConnected() {
        return count == 1;
    }
}
    
}
