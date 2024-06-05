package model;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchModel {
    
    public static void dfsSearch(Graph graph, int startVertex){
        boolean[] visited = new boolean[graph.getMaxVertices()];
        dfs(graph, startVertex, visited);
    }
    
    private static void dfs(Graph graph, int startVertex, boolean[] visited){
        
        visited[startVertex] = true;
        Vertex root = graph.getVertex(startVertex);
        LinkedList<Vertex> neighbors = root.getEdges();
        
        for (var neighbor : neighbors){
            int position = neighbor.getPosition();
            if(!visited[position]){
                dfs(graph, position, visited);
            }
        }
    }
    
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
