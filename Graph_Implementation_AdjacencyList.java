import java.util.*;

public class Graph_Implementation_AdjacencyList {
    static class Edge {
        int src = 0;
        int dest = 0;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGrap(ArrayList<Edge> graph[]) {
        for(int i =0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 4));
            graph[1].add(new Edge(1, 2));
            graph[1].add(new Edge(1, 3));
            graph[1].add(new Edge(1, 4));
            graph[2].add(new Edge(2, 4));
            graph[2].add(new Edge(2, 1));

    }
}
