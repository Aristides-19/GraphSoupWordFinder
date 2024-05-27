package model;

/**
 *
 * @author Arístides Pérez & Jesús Duarte
 * @param <T> nodes can hold any object
 */
public class LinkedList<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Inserts a node to the end of the list
     *
     * @param data data of the node that will be inserted
     */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            first = newNode;
        } else {
            first.setNext(newNode);
        }
        size++;
    }

    /**
     * Get a Node from the list by his index, it can throw an
     * IndexOutOfBoundsException
     *
     * @param index index from the node to request, starts at zero
     * @return the Node object itself
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Node<T> get(int index) {

        if (index < 0 || index >= size || isEmpty()) {
            throw new IndexOutOfBoundsException("Index Out of List Size: " + index);

        } else {
            Node<T> aux = first;

            for (int i = 0; i <= index; i++) {

                aux = aux.getNext();
            }

            return aux;
        }

    }

    /**
     * Delete a Node from the list by his index, it can throw an
     * IndexOutOfBoundsException
     *
     * @param index index from the node to delete, starts at zero
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void delete(int index) {
        Node<T> toDelete = get(index);

        if (index != 0) {
            Node<T> aux = get(index - 1);
            aux.setNext(toDelete.getNext());

        } else {
            first = first.getNext();
        }

        toDelete.setNext(null);
        toDelete.setData(null);
        size--;
    }

    /**
     *
     * @return A string representation of the list
     */
    @Override
    public String toString() {

        if (!isEmpty()) {
            Node<T> aux = first;
            String toReturn = "";

            for (int i = 0; i < size; i++) {
                toReturn += aux.getData() + " ";
                aux = aux.getNext();
            }

            return toReturn;
        }

        return "";
    }

    /**
     *
     * @return true if the list is empty (size equals zero)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

}
