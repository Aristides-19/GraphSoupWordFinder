package model;

/**
 * Creates a undirected graph where its vertices are connected by bidirectional
 * edges
 *
 * @author Arístides Pérez
 * @param <T> vertices can hold any object
 */
public class Graph<T> {
// TODO missing methods: getVertex, getNeighbors, degreeIn, degreeOut

    private int size, currentVertices;
    final private int maxVertices;
    private final Vertex<T>[] vertices;

    public Graph(int maxVertices) {
        this.maxVertices = maxVertices;
        this.size = 0;
        this.currentVertices = 0;
        this.vertices = new Vertex[maxVertices];
    }

    /**
     * Add a new vertex to the first available index
     *
     * @param data data of the vertex to add
     * @return the index of the new vertex
     * @throws IllegalStateException if the graph is at maximum capacity
     */
    public int addVertex(T data) {
        if (currentVertices != maxVertices) {

            int index = searchNullIndex();
            vertices[index] = new Vertex<>(data, index);
            currentVertices++;
            return index;
        }

        throw new IllegalStateException("The num of vertices has reached maximum num of vertices");
    }

    /**
     * Add a new vertex to the specified index. It can not replace an existing
     * vertex
     *
     * @param data data of the vertex to add
     * @param index the index of the new vertex
     * @throws ArrayIndexOutOfBoundsException if the specified index is out of
     * range
     * @throws IllegalStateException if the index is already took by another
     * vertex
     */
    public void addVertex(T data, int index) {
        verifyIndex(index);

        if (vertices[index] != null) {
            throw new IllegalStateException("The vertex " + index + " already exists");
        }

        vertices[index] = new Vertex<>(data, index);
        currentVertices++;
    }

    /**
     * Add a new edge between two vertices, if a vertex does not exist, it is
     * created at that index with null data. You must replace the data of a node
     * created by this method to avoid a NullPointerException
     *
     * @param from the vertex A from the edge
     * @param to the vertex B from the edge
     * @throws IllegalStateException if the index is already took by another
     * vertex
     * @throws IllegalArgumentException if From argument equals to To
     * @throws ArrayIndexOutOfBoundsException if the specified index is out of
     * range
     */
    public void addEdges(int from, int to) {
        verifyIndex(from);
        verifyIndex(to);

        if (from == to) {
            throw new IllegalArgumentException("FROM argument can not be equals to TO");
        }
        if (vertices[from] == null) {
            addVertex(null, from);
        }
        if (vertices[to] == null) {
            addVertex(null, to);
        }

        if (!vertices[from].getEdges().contains(vertices[to])) {

            vertices[from].getEdges().insert(vertices[to]);
            vertices[to].getEdges().insert(vertices[from]);
            size++;
        }
    }

    /**
     * Replace the data attribute from the vertex. It is useful when the method
     * addEdges creates a new vertex with null data.
     *
     * @param data data to be set as new data
     * @param index index of the vertex to replace data
     * @throws NullPointerException if the vertex does not exist
     * @throws ArrayIndexOutOfBoundsException if the specified index is out of
     * range
     */
    public void replaceVertexData(T data, int index) {
        verifyIndex(index);

        if (vertices[index] == null) {
            throw new NullPointerException("This vertex does not exist");
        }

        vertices[index].setData(data);
    }

    /**
     *
     * @return A string representation of the graph with vertices and its
     * neighbors
     */
    @Override
    public String toString() {
        if (!isEmpty()) {
            String toReturn = "";
            int i = 0;

            for (Vertex V : vertices) {
                toReturn += V != null ? V.toString() + "\n" : "";
            }

            return toReturn + "Size by Edges: " + size + "\n"
                    + "Max. Capacity: " + maxVertices + "\n"
                    + "Size by Vertices: " + currentVertices;
        }

        return "";
    }

    /**
     * It verifies if the index is valid for the graph
     *
     */
    private void verifyIndex(int index) {
        if (index < 0 || index >= maxVertices) {
            throw new ArrayIndexOutOfBoundsException("Index must be between 0 and " + (maxVertices - 1));
        }
    }

    /**
     * Search the first ocurrence of null index
     *
     * @return the index number equals to null. It returns -1 if not found
     */
    private int searchNullIndex() {
        for (int i = 0; i < maxVertices; i++) {
            if (vertices[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return true if the graph is empty (currentVertices equals zero)
     */
    public boolean isEmpty() {
        return currentVertices == 0;
    }

    /**
     *
     * @return number of edges of the graph
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return maximum capacity of the graph
     */
    public int getMaxVertices() {
        return maxVertices;
    }

    /**
     *
     * @return number of vertices created currently
     */
    public int getCurrentVertices() {
        return currentVertices;
    }
    
    /**
     *
     * @return vertices created currently
     */
    public Vertex<T>[] getVertices() {
        return vertices;
    }
    
}
