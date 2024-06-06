package model;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchModel {

    /**
     * Looks for the first letter of the word in the list of vertices of the graph to use as a root in the Depth-First-Algorithm
     *
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    public static boolean dfsSearch(Graph graph, char[] word) {
        boolean[] visited = new boolean[graph.getMaxVertices()];
        boolean isWord = false;
        
        for(var vertice : graph.getVertices()){
            if(vertice.getData().equals(word[0])){
                isWord = dfs(graph, word, 1, vertice, visited, isWord);
                if (isWord){
                    break;
                }
            }
        }
        return isWord;
    }
    
    /**
     * Search from the second letter onwards
     *
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @param letter index of the letter of the word that we are going to compare
     * @param root vertex whose adjacencies we will use
     * @param visited arrays indicating which vertices were visited
     * @param search boolean indicating whether the word was founded
     * @return a boolean value that depends on whether the word is in the graph
     */
    private static boolean dfs(Graph graph, char[] word, int letter, Vertex root, boolean[] visited, boolean search){
        System.out.print(root.getData() + " ");
        
        if (letter<word.length){
            int startVertex = root.position;
            visited[startVertex] = true;
            LinkedList<Vertex> neighbors = root.getEdges();

            for (var neighbor : neighbors){
                int position = neighbor.getPosition();
                if((!visited[position]) & (neighbor.getData().equals(word[letter]))){
                    search = dfs(graph, word, letter+1, neighbor, visited, search);
                }
            }
        }
        else{
            search = true;
        } 
        return search;
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
