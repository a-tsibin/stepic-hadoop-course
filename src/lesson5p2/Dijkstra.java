package lesson5p2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Scanner scanner = new Scanner(System.in);
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        Graph graph = dijkstra.new Graph(vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            graph.addEdge(dijkstra.new Edge(from, to, weight));
        }
        int startV = scanner.nextInt() - 1;
        int destV = scanner.nextInt() - 1;
        System.out.println(graph.findMinPath(startV, destV));
    }

    public class Graph {
        private final int v;
        private ArrayList<Edge>[] adjacencyList;

        public Graph(int v) {
            this.v = v;
            adjacencyList = (ArrayList<Edge>[]) new ArrayList[v];
        }

        public int getV() {
            return v;
        }

        public void addEdge(Edge edge) {
            if (adjacencyList[edge.getFrom()] == null)
                adjacencyList[edge.getFrom()] = new ArrayList<>();
            adjacencyList[edge.getFrom()].add(edge);
        }

        public int findMinPath(int from, int to) {
            int[] dist = new int[v];
            Set<Integer> unusedV = new HashSet<>(IntStream.rangeClosed(0, v - 1).boxed().collect(Collectors.toSet()));
            for (int i = 0; i < v; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[from] = 0;
            while (!unusedV.isEmpty()) {
                int closestVertex = getClosestVertex(dist, unusedV);
                if (closestVertex == -1)
                    break;
                unusedV.remove(closestVertex);
                if (adjacencyList[closestVertex] != null)
                    adjacencyList[closestVertex]
                            .forEach(edge -> dist[edge.getTo()] =
                                    Math.min(dist[edge.getTo()], dist[closestVertex] + edge.getWeight()));
            }

            if (dist[to] == Integer.MAX_VALUE)
                return -1;
            else
                return dist[to];
        }

        private int getClosestVertex(int[] dist, Set<Integer> unusedV) {
            Optional<Integer> vertex = unusedV.stream().filter((v) -> dist[v] < Integer.MAX_VALUE)
                    .sorted((v1, v2) -> dist[v1] - dist[v2])
                    .findFirst();
            if (!vertex.isPresent())
                return -1;
            return vertex.get();
        }
    }

    public class Edge implements Comparable<Edge> {
        private final int from;
        private final int to;
        private final int weight;

        public Edge(int from, int w, int weight) {
            this.from = from;
            this.to = w;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.getWeight() - o.getWeight();
        }
    }
}
