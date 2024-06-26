package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Singly Linked List with last and first node. It is iterable through a
 * For-Each
 *
 * @author Arístides Pérez & Jesús Duarte
 * @param <T> nodes can hold any object
 */
public class LinkedList<T> implements Iterable<T> {

    private NodeList<T> first;
    private NodeList<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Insert a node to the end of the list. Complexity: O(1)
     *
     * @param data data of the node that will be inserted
     */
    public void insert(T data) {
        NodeList<T> newNode = new NodeList<>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    /**
     * Insert a node to the beginning of the list. Complexity: O(1)
     *
     * @param data data of the node that will be inserted
     */
    public void insertAtFirst(T data) {
        NodeList<T> newNode = new NodeList<>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }

        size++;
    }

    /**
     * Get a Node Data from the list by his index, it can throw an
     * IndexOutOfBoundsException. Complexity: O(n) and O(1) if the node is the
     * first or last
     *
     * @param index index from the node to request, starts at zero
     * @return the Node data
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        return (T) get(index, false);
    }

    /**
     * Get a Node.
     *
     * @param index index from the node to request, starts at zero
     * @param nodeItSelf if wants to return the node object itself
     * @return node data or node object
     */
    private Object get(int index, boolean nodeItSelf) {

        if (index < 0 || index >= size || isEmpty()) {
            throw new IndexOutOfBoundsException("Index Out of List Size: " + index);

        } else if (index == size - 1) {
            return nodeItSelf ? last : last.getData();

        } else {
            NodeList<T> aux = first;

            for (int i = 0; i < index; i++) {

                aux = aux.getNext();
            }

            return nodeItSelf ? aux : aux.getData();
        }

    }

    /**
     * Change the data from a node by its index
     *
     * @param index index of node
     * @param data new data
     */
    public void set(int index, T data) {
        NodeList<T> toSet = (NodeList<T>) get(index, true);
        toSet.setData(data);
    }

    /**
     * Verifies if the object itself is contained in the list
     *
     * @param element object to be compared
     * @return true if the object is contained, else false
     */
    public boolean contains(T element) {
        for (T node : this) {
            if (element instanceof String) {
                if (element.equals(node)) {
                    return true;
                }
            } else if (element == node) {
                return true;
            }
        }

        return false;
    }

    /**
     * Delete a Node from the list by his index, it can throw an
     * IndexOutOfBoundsException. Complexity: O(n) and O(1) if the node is the
     * first.
     *
     * @param index index from the node to delete, starts at zero
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void delete(int index) {
        NodeList<T> toDelete = (NodeList<T>) get(index, true);

        // not first case
        if (index != 0) {
            NodeList<T> aux = (NodeList<T>) get(index - 1, true);
            aux.setNext(toDelete.getNext());
            last = index == size - 1 ? aux : last;

        } else {
            first = first.getNext();
        }

        toDelete.setNext(null);
        toDelete.setData(null);
        size--;
    }

    /**
     * A string representation of the list
     *
     * @return String List
     */
    @Override
    public String toString() {

        if (!isEmpty()) {
            String toReturn = "[";

            for (T element : this) {
                toReturn += element + ", ";
            }

            return toReturn.substring(0, toReturn.length() - 2) + "]";
        }

        return "[]";
    }

    /**
     * Check if the list si empty
     *
     * @return boolean value representing description
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Data of first node
     *
     * @return Data of first node
     */
    public T getFirst() {
        return first.getData();
    }

    /**
     * Data of last node
     *
     * @return Data of last node
     */
    public T getLast() {
        return last.getData();
    }

    /**
     * Current size of the list
     *
     * @return integer size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Makes LinkedList iterable
     *
     * @return iterable linked list
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private NodeList<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos");
            }

            T value = current.getData();
            current = current.getNext();
            return value;
        }

    }
}
