package HomeWork.Graph_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessRestrictedFriendRequests {
  
class DisjoinSet {
    private final int [] parent;
    private final int [] rank;
    private final List<Set<Integer>> restrictions;

    DisjoinSet(int size, int[][] restrictions){
        this.parent = new int [size];
        this.rank = new int [size];     
        this.restrictions = new ArrayList<>(size);

        for(int i =0; i <size; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
            this.restrictions.add(new HashSet<>());
        }

        for (int [] restriction: restrictions){
            this.restrictions.get(restriction[0]).add(restriction[1]);
            this.restrictions.get(restriction[1]).add(restriction[0]);
        }
    }

    private int find(int node){
        int root=node;
        while(parent[root]!=root){
            root=parent[root];
        }

        while (parent[node]!=root){
            int next = parent[node];
            parent[node]=root;
            node = next;
        }
        return root;
    }

    public boolean union (int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1==p2){
            return true;
        }
            
        if (notRestricted(p1,p2)){
            if (rank[p1]>rank[p2]){
                rank[p1]+=rank[p2];
                parent[p2]=p1;

                for (int node: restrictions.get(p2)){
                    restrictions.get(p1).add(find(node) );
                }
            } else{
                rank[p2]+=rank[p1];
                parent[p1]= p2;
             
                for (int node: restrictions.get(p1)){
                    restrictions.get(p2).add(find(node) );
                }
            }
            return true;
        }
        return false;
    }
    
        private boolean notRestricted(int root1, int root2) {
            if (restrictions.get(root1).contains(root2))
                return false;
            if (restrictions.get(root2).contains(root1))
                return false;
        return true;
    }
}

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        if (restrictions.length==0){
            boolean [] queries = new boolean [requests.length];
            Arrays.fill(queries,true);
            return queries;
        }
         DisjoinSet set = new DisjoinSet(n,restrictions);
         boolean [] queries = new boolean [requests.length];
         for (int i =0; i<requests.length ;i++){
            queries[i] = set.union(requests[i][0],requests[i][1] );
         }
        return queries;
    }
}
}
