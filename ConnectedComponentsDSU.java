import java.util.*;

public class ConnectedComponentsDSU {
    
    static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;  // Merge x's set into y's set
            }
        }
    }

    public static int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        Set<Integer> uniqueComponents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueComponents.add(dsu.find(i));
        }

        return uniqueComponents.size();
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };
        System.out.println(countComponents(n, edges));  // Output: 2
    }
}
