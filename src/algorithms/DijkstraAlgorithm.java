package algorithms;

import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int to, weight;
        public Edge(int target, int weight) {
            this.to = target;
            this.weight = weight;
        }
    }

//    public static void dijkstra(int source, List<List<Edge>> graph) {
//        int n = graph.size();
//        int[] distances = new int[n];
//        Arrays.fill(distances, Integer.MAX_VALUE);
//        distances[source] = 0;
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        pq.offer(new int[]{source, 0});
//
//        while (!pq.isEmpty()) {
//            int[] current = pq.poll();
//            int node = current[0];
//            int dist = current[1];
//
//            // If the distance is outdated, skip this node
//            if (dist > distances[node]) continue;
//
//            for (Edge edge : graph.get(node)) {
//                int newDist = distances[node] + edge.weight;
//                if (newDist < distances[edge.target]) {
//                    distances[edge.target] = newDist;
//                    pq.offer(new int[]{edge.target, newDist});
//                }
//            }
//        }
//
//        System.out.println("Shortest distances from node " + source + ":");
//        for (int i = 0; i < n; i++) {
//            System.out.println("To node " + i + " -> " + distances[i]);
//        }
//    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(
                new Edge(1, 3), // s -> a
                new Edge(3, 14), // s -> d
                new Edge(4, 12)  // s -> e
        ));
        graph.put(1, Arrays.asList(
                new Edge(2, 1)   // a -> b
        ));
        graph.put(2, Arrays.asList(
                new Edge(3, 2),  // b -> c
                new Edge(4, 7)   // b -> e
        ));
        graph.put(3, Arrays.asList(
                new Edge(4, 2)   // c -> e
        ));
        graph.put(4, Arrays.asList(
                new Edge(5, 2)   // d -> e
        ));
        // Run Dijkstra's algorithm from source node 0
        dijkstra( graph, 0);
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int source) {
        // Distance map
        Map<Integer, Integer> D = new HashMap<>();
        // Predecessor map
        Map<Integer, Integer> p = new HashMap<>();
        // Boundary set
        Set<Integer> R = new HashSet<>();
        // Tree set
        Set<Integer> B = new HashSet<>();
        // Unknown nodes
        Set<Integer> U = new HashSet<>(graph.keySet());

        // Initialize distances and predecessors
        for (int node : graph.keySet()) {
            D.put(node, Integer.MAX_VALUE); // Distance is initially infinity
            p.put(node, null);             // No predecessor
        }
        D.put(source, 0); // Distance to the source is 0
        R.add(source);    // Start with the source in the boundary set
        U.remove(source); // Remove source from unknown nodes

        // Main while-loop
        while (!R.isEmpty()) {
            // Find the node x in R with the smallest distance D(x)
            int x = -1, alpha = Integer.MAX_VALUE;
            for (int y : R) {
                if (D.get(y) < alpha) {
                    x = y;
                    alpha = D.get(y);
                }
            }

            // Move x from R to B
            B.add(x);
            R.remove(x);

            // Relax edges from x
            for (Edge edge : graph.getOrDefault(x, new ArrayList<>())) {
                int y = edge.to;
                if (U.contains(y)) { // If y is in U
                    if (D.get(x) + edge.weight < D.get(y)) {
                        D.put(y, D.get(x) + edge.weight);
                        p.put(y, x);
                    }
                    U.remove(y);
                    R.add(y);
                } else if (R.contains(y) && D.get(x) + edge.weight < D.get(y)) { // If y is in R
                    D.put(y, D.get(x) + edge.weight);
                    p.put(y, x);
                }
            }

            

            // Print values of the variables after this iteration
            System.out.println("After processing node " + x + " (distance = " + D.get(x) + "):");
            System.out.println("B (tree nodes): " + B);
            System.out.println("R (boundary nodes): " + R);
            System.out.println("U (unknown nodes): " + U);
            System.out.println("D (distances): " + D);
            System.out.println("p (predecessors): " + p);
            System.out.println("---------------------------");
        }
    }

    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String hours = timePoints.get(i).substring(0, 3);
            String min = timePoints.get(i).substring(2);
            arr[i] = (Integer.parseInt(hours)*60 + Integer.parseInt(min));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int min1 = arr[i + 1] - arr[i];
            if (min1 < min){
                min = min1;
                if (min1 == 0) return min1;
            }
        }

        int time = 24*60;
        for (int i = 0; i < arr.length; i++) {
            int min1 = (time + arr[i]) - arr[arr.length-1];
            if (min1 < min){
                min = min1;
                if (min1 == 0) return min1;
            }
        }

        return min;
    }

}
