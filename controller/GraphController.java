package controller;

import model.Graph;

/**
 *
 * @author Arístides Pérez & Jesús Duarte
 */
public class GraphController {

     /**
     * Create the graph
     *
     * @param letters
     * @return 
     */
    static Graph creatGraph(String[] letters) {
        Graph graph = new Graph (16);
        String info;
        
        for (int i=0; i<graph.getMaxVertices(); i++){
            info = letters[i];
            
            graph.addVertex(info);
        }
        
        return graph;
    }
    
    /**
     * Create the linked list for each vertex
     *
     *  
     * @param graph
     */
    static void creatLinkedList(Graph graph) {
        
        for (int i=0; i<graph.getMaxVertices()-1; i++){
                
            if(i+1%4!=0){
                graph.addEdges(i, i+1);
            }
            
            if(i+1<13){
                if((i+1)%4!=1){
                   graph.addEdges(i, i+3);
                } 
                
                graph.addEdges(i, i+4);
                
                if((i+1)%4!=0){
                    graph.addEdges(i, i+5);
                }
            }
        }
    }
}
