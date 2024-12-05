package algorithms;

import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int target, weight;
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void dijkstra(int source, List<List<Edge>> graph) {
        int n = graph.size(); // Number of nodes
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            // If the distance is outdated, skip this node
            if (dist > distances[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = distances[node] + edge.weight;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " -> " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int n = 6; // Number of nodes
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Add edges (from, to, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(2, 5));
        graph.get(1).add(new Edge(3, 10));
        graph.get(2).add(new Edge(4, 3));
        graph.get(4).add(new Edge(3, 4));
        graph.get(3).add(new Edge(5, 11));

        // Run Dijkstra's algorithm from source node 0
        dijkstra(0, graph);
    }
}
