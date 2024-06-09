package model;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 * A class to use BFS and DFS algorithm's and display their traverse graph with
 * GraphStream. If looking for DFS and DFS Javadoc's, you have to look on
 * WordSearchModel class
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchGraphDisplay {

    /**
     * Looks for the first letter of the word in the list of vertices of the
     * graph to use as a root in the chosen algorithm. This method creates the
     * SingleGraph and shows the traverse graph of every possible path to find
     * the word
     *
     * @param algorithm if > 0 it uses DFS, otherwise BFS
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    private static boolean callFromRootAndDisplay(int algorithm, Graph graph, char[] word) {
        boolean[] visited = new boolean[graph.getMaxVertices()];
        SingleGraph graphView = new SingleGraph("Grafo DFS");
        boolean isWord = false;
        boolean partialResult = false;

        for (var vertex : graph.getVertices()) {
            if (vertex.getData().equals(word[0])) {

                // Try-Catch to avoid already visited vertices that can be a root for the search
                try {
                    Node nodo = graphView.addNode(String.valueOf(vertex.getPosition()));
                    nodo.setAttribute("ui.label", String.valueOf(vertex.getData()));
                } catch (IdAlreadyInUseException e) {

                }
                if (algorithm > 0) {
                    partialResult = dfsLib(graphView, word, 1, vertex, visited, isWord);
                } else {
                    partialResult = bfsLib(graphView, vertex, word, visited);
                }

                if (isWord == false) {
                    isWord = partialResult;
                }
            }
        }

        if (isWord) {
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: green;}");
        } else {
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: red;}");
        }

        System.setProperty("org.graphstream.ui", "swing");
        Viewer actualGraph = graphView.display();
        actualGraph.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);

        return isWord;
    }

    /**
     * Looks for the first letter of the word in the list of vertices of the
     * graph to use as a root in the Depth-First-Algorithm
     *
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    public static boolean viewDfs(Graph graph, char[] word) {
        return callFromRootAndDisplay(1, graph, word);
    }

    private static boolean dfsLib(SingleGraph graphView, char[] word, int letter, Vertex root, boolean[] visited, boolean search) {

        if (letter < word.length) {
            int startVertex = root.getPosition();
            visited[startVertex] = true;
            LinkedList<Vertex> neighbors = root.getEdges();

            for (var neighbor : neighbors) {
                int position = neighbor.getPosition();

                if ((!visited[position]) && (neighbor.getData().equals(word[letter]))) {
                    addEdge(graphView, root, neighbor);
                    search = dfsLib(graphView, word, letter + 1, neighbor, visited, search);
                }
            }
        } else {
            return true;
        }
        return search;
    }

    /**
     * Looks for the first letter of the word in the list of vertices of the
     * graph to use as a root in the Breadth-First-Algorithm
     *
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    public static boolean viewBfs(Graph graph, char[] word) {
        return callFromRootAndDisplay(0, graph, word);
    }

    private static boolean bfsLib(SingleGraph graphView, Vertex root, char[] word, boolean[] visited) {

        int currentNeighbor;
        Queue<Vertex> queue = new Queue<>();
        int character = 1;
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        boolean foundCharacter = false;
        boolean isWord = false;

        queue.enqueue(root);
        visited[root.getPosition()] = true;

        while (!queue.isEmpty() && character < word.length) {

            Vertex currentVertex = queue.dequeue();
            currentLevelCount--;
            LinkedList<Vertex> neighbors = currentVertex.getEdges();

            for (var neighbor : neighbors) {
                currentNeighbor = neighbor.getPosition();

                if ((!visited[currentNeighbor]) && (neighbor.getData().equals(word[character]))) {
                    visited[currentNeighbor] = true;
                    queue.enqueue(neighbor);
                    nextLevelCount++;
                    foundCharacter = true;

                    addEdge(graphView, currentVertex, neighbor);
                }
            }

            if (currentLevelCount == 0 && foundCharacter) {
                character++;
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                foundCharacter = false;

                if (character == word.length && isWord == false) {
                    isWord = true;
                }
            }
        }

        return isWord;
    }

    /**
     * Add an edge between two vertices in the SingleGraph
     *
     * @param graphView graph object to insert edge
     * @param src source vertex of the edge
     * @param dst destiny vertex of the edge
     */
    private static void addEdge(SingleGraph graphView, Vertex src, Vertex dst) {
        String aux1 = String.valueOf(src.getPosition());
        String aux2 = String.valueOf(dst.getPosition());

        // Try-Catch's to avoid already visited vertices
        try {
            Node nodo = graphView.addNode(aux2);
            nodo.setAttribute("ui.label", String.valueOf(dst.getData()));

        } catch (IdAlreadyInUseException e) {

        }

        try {
            graphView.addEdge(aux1 + "-" + aux2, aux1, aux2);
        } catch (EdgeRejectedException | IdAlreadyInUseException e) {

        }
    }
}
