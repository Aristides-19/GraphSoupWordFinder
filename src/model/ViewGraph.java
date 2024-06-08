package model;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author jesus
 */
public class ViewGraph {
    
    public static boolean viewDfs(GraphADS graph, char[] word){
        Graph graphView = new SingleGraph("Grafo DFS");
        boolean[] visited = new boolean[graph.getMaxVertices()];
        boolean isWord = false;
        
        for(var vertice : graph.getVertices()){
            if(vertice.getData().equals(word[0])){
                try{
                    Node nodo = graphView.addNode(String.valueOf(vertice.getPosition()));
                    nodo.setAttribute("ui.label", String.valueOf(vertice.getData()));  
                }
                catch(IdAlreadyInUseException e){

                }
                isWord = dfsLib(graph, graphView, word, 1, vertice, visited, isWord);
            }
        }
        
        if(isWord){
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: green;}");
        }
        else{
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: red;}");
        }
        
        System.setProperty("org.graphstream.ui", "swing");
        graphView.display();
        return isWord;
    }
    
    public static boolean dfsLib(GraphADS graph, Graph graphView, char[] word, int letter, Vertex root, boolean[] visited, boolean search){
        System.out.print(root.getData() + " ");
        
        if (letter<word.length){
            int startVertex = root.position;
            visited[startVertex] = true;
            LinkedList<Vertex> neighbors = root.getEdges();
            Node nodo;

            for (var neighbor : neighbors){
                int position = neighbor.getPosition();
                if((!visited[position]) & (neighbor.getData().equals(word[letter]))){
                    String aux1 = String.valueOf(root.getPosition());
                    String aux2 = String.valueOf(neighbor.getPosition());
                    try{
                        nodo = graphView.addNode(aux2);
                        nodo.setAttribute("ui.label", String.valueOf(neighbor.getData())); 
                        
                    }
                    catch(IdAlreadyInUseException e){
            
                    }
                    try{
                        graphView.addEdge(aux1+"-"+aux2, aux1, aux2);
                    }
                    catch(Exception e){
                        
                    }
                    search = dfsLib(graph, graphView, word, letter+1, neighbor, visited, search);
                }
            }
        }
        else{
            search = true;
        } 
        return search;
    }
    
    public static boolean viewBfs(GraphADS graph, char[] word){
        boolean isWord = false;
        Graph graphView = new SingleGraph("Grafo DFS");
        
        for(var vertice : graph.getVertices()){
            if(vertice.getData().equals(word[0])){
                isWord = bfsLib(graph, graphView, vertice, word);
            }
        }
        
        if(isWord){
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: green;}");
        }
        else{
            graphView.setAttribute("ui.stylesheet", "node { text-size: 70px; size: 20px; fill-color: red;}");
        }
        
        System.setProperty("org.graphstream.ui", "swing");
        graphView.display();
        return isWord;
    }
    
    public static boolean bfsLib(GraphADS graph, Graph graphView, Vertex root, char[] word){
        
        int startVertex = root.getPosition();
        int currentNeighbor;
        Queue<Vertex> queue = new Queue<>();
        boolean[] visited = new boolean[graph.getMaxVertices()];
        int caracter = 1;
        int counter1 = 1;
        int counter2 = 0;
        boolean counter3 = false;
        boolean isWord = false;
        Node nodo;
        
        queue.enqueue(root);
        try{
            nodo = graphView.addNode(String.valueOf(root.getPosition()));
            nodo.setAttribute("ui.label", String.valueOf(root.getData()));  
        }
        catch(IdAlreadyInUseException e){
            
        }
        visited[startVertex] = true; 
        
        while (!queue.isEmpty() & caracter<word.length) {
            
            counter1--;
            
            Vertex currentVertex = queue.dequeue();
            LinkedList<Vertex> neighbors = currentVertex.getEdges();
            
            for (var neighbor : neighbors) {
                currentNeighbor = neighbor.getPosition();

                if ((!visited[currentNeighbor]) & (neighbor.getData().equals(word[caracter]))) {
                    visited[currentNeighbor] = true;
                    queue.enqueue(neighbor);
                    counter2++;
                    counter3=true;
                    String aux1 = String.valueOf(currentVertex.getPosition());
                    String aux2 = String.valueOf(neighbor.getPosition());
                    try{
                        nodo = graphView.addNode(aux2);
                        nodo.setAttribute("ui.label", String.valueOf(neighbor.getData())); 
                        
                    }
                    catch(IdAlreadyInUseException e){
            
                    }
                    try{
                        graphView.addEdge(aux1+"-"+aux2, aux1, aux2);
                    }
                    catch(Exception e){
                        
                    }
                }
            }
            
            if((counter1 == 0) & counter3){
                caracter++;
                counter1=counter2;
                counter2=0;
                counter3=false;
                if (caracter==word.length){
                    isWord = true;
                }
            }
        }
        
        return isWord;
    }
}
