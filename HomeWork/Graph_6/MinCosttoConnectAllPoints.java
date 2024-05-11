package HomeWork.Graph_6;

import java.util.ArrayList;
import java.util.Collections;

public class MinCosttoConnectAllPoints {
    class Solution {

    static int par[];
    static int rank[];

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;
        if(rank[a]>=rank[b]){
            par[b] = a;
            rank[a]++;
        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    public int minCostConnectPoints(int[][] point) {
        int v = point.length;

        ArrayList<int[]> arr = new ArrayList<>();

        par = new int[v];
        rank = new int[v];

        for(int i=0; i<v; i++){
            par[i] = i;
        }

        for(int i=0; i<v; i++){
            for(int j=i+1; j<v; j++){
                int cost = Math.abs(point[i][0]-point[j][0])+Math.abs(point[i][1]-point[j][1]);

                arr.add(new int[]{i,j,cost});
            }
        }

        Collections.sort(arr,(a,b)->(a[2]-b[2]));

        int ans = 0;

        for(int i=0; i<arr.size(); i++){
            int a = arr.get(i)[0];
            int b = arr.get(i)[1];

            if(find(a)!=find(b)){
                union(a,b);
                ans = ans + arr.get(i)[2];
            }
        }
        return ans;

    }
}
}
