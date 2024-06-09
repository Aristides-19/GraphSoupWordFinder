package model;

/**
 * WordSearchModel stores the BFS and DFS algorithm's
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class WordSearchModel {

    /**
     * Looks for the first letter of the word in the list of vertices of the
     * graph to use as a root in the chosen algorithm
     *
     * @param algorithm if > 0 it uses DFS, otherwise BFS
     * @param graph the graph where we are going to search for the word
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    private static boolean callFromRoot(int algorithm, Graph graph, char[] word) {
        boolean[] visited = new boolean[graph.getMaxVertices()];
        boolean isWord = false;

        for (var vertice : graph.getVertices()) {
            if (vertice.getData().equals(word[0])) {
                isWord = algorithm > 0 ? dfs(word, 1, vertice, visited, isWord) : bfs(vertice, word, visited);
                if (isWord) {
                    break;
                }
            }
        }
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
    public static boolean dfsSearch(Graph graph, char[] word) {
        return callFromRoot(1, graph, word);
    }

    /**
     * Search from the second letter onwards
     *
     * @param word the word we are going to look for
     * @param letter index of the letter of the word that we are going to
     * compare
     * @param root vertex whose adjacencies we will use
     * @param visited arrays indicating which vertices were visited
     * @param search boolean indicating whether the word was found
     * @return a boolean value that depends on whether the word is in the graph
     */
    private static boolean dfs(char[] word, int letter, Vertex root, boolean[] visited, boolean search) {

        if (letter < word.length) {
            int startVertex = root.getPosition();
            visited[startVertex] = true;
            LinkedList<Vertex> neighbors = root.getEdges();

            for (var neighbor : neighbors) {
                int position = neighbor.getPosition();

                if ((!visited[position]) && (neighbor.getData().equals(word[letter]))) {
                    search = dfs(word, letter + 1, neighbor, visited, search);

                    if (search) {
                        break;
                    }
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
    public static boolean bfsSearch(Graph graph, char[] word) {
        return callFromRoot(1, graph, word);
    }

    /**
     * Search from the second letter onwards
     *
     * @param root bfs initial vertex
     * @param word the word we are going to look for
     * @return a boolean value that depends on whether the word is in the graph
     */
    private static boolean bfs(Vertex root, char[] word, boolean[] visited) {

        int currentNeighbor;
        Queue<Vertex> queue = new Queue<>();
        int character = 1; // character to look for
        int currentLevelCount = 1; // counts how many vertices need to traverse on the actual level
        int nextLevelCount = 0; // counts how many vertices need to traverse on next level
        boolean foundCharacter = false;

        queue.enqueue(root);
        visited[root.getPosition()] = true;

        while (!queue.isEmpty()) {

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
                }
            }

            if ((currentLevelCount == 0) && foundCharacter) {
                character++;
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                foundCharacter = false;
                if (character == word.length) {
                    return true;
                }
            }
        }

        return false;
    }
}
