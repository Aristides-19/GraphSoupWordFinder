package controller;

import model.Graph;

/**
 *
 * @author Jesús Duarte
 */
public class GraphController {

    /**
     * Create the graph (word soup 4x4) of 16 vertices
     *
     * @param letters array where each string (length 16) contains a letter from
     * the word soup
     * @return the graph object with edges
     */
    static Graph createGraph(String[] letters) {
        Graph graph = new Graph(16);
        String info;

        for (int i = 0; i < graph.getMaxVertices(); i++) {
            info = letters[i];

            graph.addVertex(info);
        }
        
        createEdges(graph);
        
        return graph;
    }

    /**
     * It creates edges for each vertex, working in a 16 vertices graph
     * representing a word soup
     *
     *
     * @param graph the graph created with createGraph method
     */
    private static void createEdges(Graph graph) {

        for (int i = 0; i < graph.getMaxVertices() - 1; i++) {

            if (i + 1 % 4 != 0) {
                graph.addEdges(i, i + 1);
            }

            if (i + 1 < 13) {
                if ((i + 1) % 4 != 1) {
                    graph.addEdges(i, i + 3);
                }

                graph.addEdges(i, i + 4);

                if ((i + 1) % 4 != 0) {
                    graph.addEdges(i, i + 5);
                }
            }
        }
    }
}
