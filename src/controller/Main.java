package controller;

import model.GraphADS;
import model.WordSearchModel;
import model.ViewGraph;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Character[] str = {'C', 'H', 'A', 'O', 'X', 'A', 'T', 'M', 'P', 'R', 'R', 'A', 'A', 'O', 'R', 'O'};
        GraphADS<Character> graph = GraphController.createGraph(str);
        char[] palabra= {'C', 'A', 'R', 'O'};
        System.out.println(graph.toString());

        System.out.println(WordSearchModel.bfsSearch(graph, palabra));
        System.out.println();
        System.out.println(WordSearchModel.dfsSearch(graph, palabra));
        System.out.println(ViewGraph.viewBfs(graph, palabra));
    }

}
