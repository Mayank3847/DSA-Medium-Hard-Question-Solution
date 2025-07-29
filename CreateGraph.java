import java.util.*;

public class CreateGraph {
    static class Edge {
        int src = 0;
        int dest = 0;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void CreateGraphDemo(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        CreateGraphDemo(graph);
      

        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                // if (e.src == n) {
                    System.out.println("Src : " + e.src + " Dest : " + e.dest);
                // }
                // else{
                // System.out.println("Not Found Source");
                // }
            }
        }
    }
}
