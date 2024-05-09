package HomeWork.Graph_4;

import java.io.*;
import java.util.*;
public class BeautifulGraph {
    



    static final int MOD = 998244353;

    static List<List<Integer>> graph;
    static int[] color;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            color = new int[n];
            Arrays.fill(color, -1);
            count = new long[3];
            boolean isBipartite = true;
            for (int i = 0; i < n; i++) {
                if (color[i] == -1) {
                    count[1] = 0;
                    count[2] = 0;
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                    long temp = count[1];
                    count[1] = count[2];
                    count[2] = temp;
                }
            }

            if (!isBipartite) {
                System.out.println(0);
            } else {
                long result = (count[1] + count[2]) % MOD;
                result = (result * modPow(3, n - (count[1] + count[2]))) % MOD;
                System.out.println(result);
            }
        }
    }

    static boolean dfs(int node, int c) {
        color[node] = c;
        count[c]++;
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 3 - c)) {
                    return false;
                }
            } else if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

    static long modPow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}