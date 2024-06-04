package model;

/**
 *
 * @author Arístides Pérez
 * @param <T> vertex can hold any object
 */
public class Vertex<T> {

    private T data;
    final private LinkedList<Vertex<T>> edges;
    final int position;

    protected Vertex(T data, int position) {
        this.data = data;
        this.edges = new LinkedList<>();
        this.position = position;
    }

    /**
     *
     * @return A string representation of the vertex and its adjacency vertices
     */
    @Override
    public String toString() {
        String toReturn = data.toString() + "[" + position + "]" + " -> ";
        if (!edges.isEmpty()) {

            for (Vertex V : edges) {
                toReturn += V.getData() + ", ";
            }

            return toReturn.substring(0, toReturn.length() - 2);
        }

        return toReturn;
    }

    /**
     * Get a Shallow Copy of the neighbors vertices contained by a Linked List
     *
     * @return a Linked List containing vertex objects
     * @throws CloneNotSupportedException
     */
    public LinkedList<Vertex<T>> getNeighbors() throws CloneNotSupportedException {
        return (LinkedList<Vertex<T>>) edges.clone();
    }

    /**
     * A not copy version of the method getNeighbors
     *
     * @return a Linked List containing vertex objects
     */
    protected LinkedList<Vertex<T>> getEdges() {
        return edges;
    }

    public int degree() {
        return edges.getSize();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }
}
