import java.util.*;

public class AliceAndBobGame {
    static int time = 0;
    static int[] inTime, outTime;
    static List<List<Integer>> tree;

    public static void dfs(int node, int parent) {
        inTime[node] = ++time;
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
            }
        }
        outTime[node] = ++time;
    }

    public static boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            int n = sc.nextInt();
            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            inTime = new int[n + 1];
            outTime = new int[n + 1];
            time = 0;
            dfs(1, -1);  // DFS from the King's Castle (root = 1)

            int q = sc.nextInt();
            while (q-- > 0) {
                int dir = sc.nextInt();  
                int x = sc.nextInt();    
                int y = sc.nextInt();     

                boolean canFind = false;
                if (dir == 0) {
                    canFind = isAncestor(y, x);
                } else {
                    canFind = isAncestor(x, y);
                }

                System.out.println(canFind ? "YES" : "NO");
            }
        }
        sc.close();
    }
}
