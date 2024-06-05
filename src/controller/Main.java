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
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        String[] str = {"C","H","A","O","X","A","T","M","P","R","R","A","A","O","R","O"};
        Graph graph = GraphController.createGraph(str);
        System.out.println(graph.toString());
        
        WordSearchModel.bfsSearch(graph, 0);
    }
    
}
