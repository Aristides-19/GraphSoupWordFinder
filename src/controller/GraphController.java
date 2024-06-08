package controller;

import model.GraphADS;

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
    static GraphADS<Character> createGraph(Character[] letters) {
        GraphADS<Character> graph = new GraphADS(16);
        Character info;

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
    private static void createEdges(GraphADS graph) {

        for (int i = 0; i < graph.getMaxVertices() - 1; i++) {

            if ((i + 1) % 4 != 0) {
                graph.addEdge(i, i + 1);
            }

            if (i + 1 < 13) {
                if ((i + 1) % 4 != 1) {
                    graph.addEdge(i, i + 3);
                }

                graph.addEdge(i, i + 4);

                if ((i + 1) % 4 != 0) {
                    graph.addEdge(i, i + 5);
                }
            }
        }
    }
}
