package model;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchModel {

    public static void dfsSearch(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getMaxVertices()];
        dfs(graph, startVertex, visited);
    }

    private static void dfs(Graph graph, int startVertex, boolean[] visited) {

        visited[startVertex] = true;
        Vertex root = graph.getVertex(startVertex);
        LinkedList<Vertex> neighbors = root.getEdges();
        System.out.print(root.getData() + " ");

        for (var neighbor : neighbors) {
            int position = neighbor.getPosition();
            if (!visited[position]) {
                dfs(graph, position, visited);
            }
        }
    }

    public static Vertex getRoot(Graph graph, String word) {
        Character rootChar = word.charAt(0);
        Vertex V;

        for (int i = 0; i < graph.getMaxVertices(); i++) {
            V = graph.getVertex(i);
            if (V.getData() == rootChar) {
                return V;
            }
        }

        return null;
    }

    /**
     * Print the traverse of a Breadth First Search algorithm in a graph
     *
     * @param graph the graph to be traversed
     * @param startVertex the index of the vertex to start the traverse
     */
    public static void bfsSearch(Graph graph, int startVertex) {

        int currentNeighbor;
        Queue<Vertex> queue = new Queue<>();
        boolean[] visited = new boolean[graph.getMaxVertices()];

        queue.enqueue(graph.getVertex(startVertex));
        visited[startVertex] = true;

        while (!queue.isEmpty()) {

            Vertex currentVertex = queue.dequeue();
            System.out.print(currentVertex.getData() + " ");
            LinkedList<Vertex> neighbors = currentVertex.getEdges();

            for (var neighbor : neighbors) {
                currentNeighbor = neighbor.getPosition();

                if (!visited[currentNeighbor]) {
                    visited[currentNeighbor] = true;
                    queue.enqueue(neighbor);
                }
            }
        }

    }
}
