package controller;

import model.Graph;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] str = {"C","H","A","O","X","A","T","M","P","R","R","A","A","O","R","O"};
        Graph graph = GraphController.createGraph(str);
        System.out.println(graph.toString());
    }
    
}
