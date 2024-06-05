package model;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchModel {

    public void dfsSearch(Graph graph, int startVertex) {

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
