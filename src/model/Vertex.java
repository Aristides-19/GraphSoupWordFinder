package model;

/**
 *
 * @author Arístides Pérez
 * @param <T> vertex can hold any object
 */
public class Vertex<T> {

    private T data;
    final private LinkedList<Vertex> edges;
    final int position;

    public Vertex(T data, int position) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedList<Vertex> getEdges() {
        return edges;
    }

    public int getPosition() {
        return position;
    }
}
