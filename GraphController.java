package controller;

import model.Graph;
import model.LinkedList;
import model.Node;
import model.Vertex;

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
    public Graph creatGraph(String[] letters) {
        Graph graph = new Graph (16);
        String info = "";
        
        for (int i=0; i<graph.getMaxVertices(); i++){
            info = letters[i];
            
            graph.addVertex(info);
        }
        
        return graph;
    }
    
    /**
     * Create the graph
     *
     *  
     * @param graph
     */
    public void creatLinkedList(Graph graph) {
        Vertex[] vertices = graph.getVertices();
        
        for (int i=0; i<graph.getMaxVertices(); i++){
            LinkedList list = new LinkedList();
            
            if(i>4){
                if(i%4!=1){
                   
                } 
                
                
                
                if(i%4!=0){
                    
                }
            }
            
            if(i%4!=1){
                
            } 
                
                
                
            if(i%4!=0){
                
            }
            
            if(i<4){
                if(i%4!=1){
                   
                } 
                
                
                
                if(i%4!=0){
                    
                }
            }
            
            Node node = new Node (vertices[i-1]);
            list.insert(node);
        }
    }
}
