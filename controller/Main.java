package controller;

import model.Graph;

/**
 *
 * @author jesus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] str = {"C","H","A","O","X","A","T","M","P","R","R","A","A","O","R","O"};
        Graph graph = GraphController.creatGraph(str);
        GraphController.creatLinkedList(graph);
    }
    
}
