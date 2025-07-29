import java.util.ArrayList;

public class CreateWtdGraph {
    static class Edge {
        int src = 0;
        int dest = 0;
        int wt = 0;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void CreateGraphDemo(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 2, 4));
        graph[1].add(new Edge(1, 3, 2));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 1, 4));
        graph[2].add(new Edge(2, 0, 5));
        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 2, 3));
    }
    public static void main(String[] args) {
         int V = 4; 
         @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        CreateGraphDemo(graph);

        System.out.println("Weighted Directed Graph:");
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                System.out.println("Src : " + e.src + " Dest :  " + e.dest + "   weight : " + e.wt);
            }
        }
    }
}
