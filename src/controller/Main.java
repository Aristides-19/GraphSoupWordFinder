package controller;

import model.Graph;
import model.WordSearchModel;

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
        Graph<Character> graph = GraphController.createGraph(str);
        System.out.println(graph.toString());

        WordSearchModel.bfsSearch(graph, 0);
    }

}
